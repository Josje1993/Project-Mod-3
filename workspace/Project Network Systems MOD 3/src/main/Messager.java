package main;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class that is responsible for sending an initial message when a node joins
 * the multicast group. Keeps listening for new messages and provides the
 * functionality to send messages to the multicast group
 * 
 * @author Joshua de Bie
 * 
 */
public class Messager implements Runnable {
	ArrayList<byte[]> dataToSend;
	MulticastSocket socket;
	int multicastPort;
	InetAddress groupAddress;
	String IP_Address;
	String nodeName;
	File inputFile;
	File outputFile;
	FileOutputStream output;
	FileInputStream input;
	BufferedReader br;
	File testfile = new File("test.docx");
	String TESTFILE = "test.txt";
	// Closing part of message;
	static final String CLOSINGMSG = " has left the group @ ";
	// Opening part of message;
	static final String INITIALMSG = " has joined the group @ ";
	static final String APPENDMSG = " > ";
	static final String WHISPERCMD = "//whisper";
	static final String CLOSECMD = "//quit";

	// --------CONSTRUCTOR----------------------------------------------------------

	public Messager(int port, String address, String name) {
		multicastPort = port;
		IP_Address = address;
		nodeName = name;
		if (nodeName.length() > 16) {
			try {
				throw new Exception(
						"Name is too long. The maximum is 20 characters.");
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		} else if (nodeName.contains(" ")) {
			try {
				throw new Exception(
						"Illegal characters found. Spaces are not allowed in names.");
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		} else if (multicastPort < 0 || multicastPort > 9999) {
			try {
				throw new Exception(
						"Invalid port number. Must be between 1000 and 9999");
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
		connect();
		run();
		sendInitialMsg();
	}

	public void fileToBytes(File file) {
		String fileAppend;
		if (nodeName.length() < 10 && file.getName().length() < 10) {
			fileAppend = "FILE" + "0" + nodeName.length() + nodeName + "0"
					+ file.getName().length() + file.getName()
					+ (int) file.length();
		} else if (nodeName.length() > 9 && file.getName().length() > 9) {
			fileAppend = "FILE" + nodeName.length() + nodeName
					+ +file.getName().length() + file.getName()
					+ (int) file.length();
		} else if (nodeName.length() < 10 && file.getName().length() > 9) {
			fileAppend = "FILE" + "0" + nodeName.length() + nodeName
					+ file.getName().length() + file.getName()
					+ (int) file.length();
		} else /* (nodeName.length() > 9 && file.getName().length() < 10) */{
			fileAppend = "FILE" + nodeName.length() + nodeName + "0"
					+ file.getName().length() + file.getName()
					+ (int) file.length();
		}
		System.out.println(fileAppend);
		byte[] fileIndicator = fileAppend.getBytes();
		byte[] bFile = new byte[(int) file.length()];
		FileInputStream fileInputStream = null;
		try {
			// convert file into array of bytes
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
			byte[] message = new byte[bFile.length + fileIndicator.length];
			for (int i = 0; i < message.length - 1; i++) {
				if (i < fileIndicator.length) {
					message[i] = fileIndicator[i];
				} else {
					message[i] = bFile[i - fileIndicator.length];
				}
			}
			sendMsg(new DatagramPacket(message, message.length, groupAddress,
					getPort()));
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// --------QUERIES--------------------------------------------------------------

	/**
	 * Returns the address of this multicast group.
	 * 
	 * @return - the address of this multicast group
	 */
	public InetAddress getGroupAddress() {
		return groupAddress;
	}

	/**
	 * Retruns the socket of this multicast group.
	 * 
	 * @return - the socket of this mulitcast group
	 */
	public MulticastSocket getSocket() {
		return socket;
	}

	/**
	 * Returns the IP address of the multicast group.
	 * 
	 * @return - the IP address of this multicast group
	 */
	public String getAddress() {
		return IP_Address;
	}

	/**
	 * Returns the port the members of this multicast group are listening to.
	 * 
	 * @return - the port the members of this multicast group are listening to
	 */
	public int getPort() {
		return multicastPort;
	}

	// --------COMMANDS-------------------------------------------------------------

	/**
	 * Creates a socket and joins the the multicast group.
	 */
	private void connect() {
		try {
			socket = new MulticastSocket(multicastPort);
			groupAddress = InetAddress.getByName(IP_Address);
			socket.joinGroup(groupAddress);
		} catch (Exception e) {
			System.err
					.print("An error occurred while setting up a connection to the group.");
		}
	}

	/**
	 * Sends a DatagramPacket with the specified Time To Live.
	 * 
	 * @param packet
	 *            - The packet that is of interest to be send.
	 * @param newTTL
	 *            - The Time To Live that is given to the packet.
	 */
	private void sendMsg(DatagramPacket packet, int newTTL) {
		try {
			int TTL = socket.getTimeToLive();
			socket.setTimeToLive(newTTL);
			socket.send(packet);
			socket.setTimeToLive(TTL);
		} catch (IOException e) {
			System.err.print("An error occurred while sending a message.");
		}
	}

	/**
	 * Sends a DatagramPacket with the default Time To Live.
	 */
	private void sendMsg(DatagramPacket packet) {
		try {
			socket.send(packet);
		} catch (IOException e) {
			System.err.print("An error occurred while sending a message");
		}
	}

	/**
	 * Broadcasts the initial message to notify all members of the presence of
	 * the node in this group the multicastgroup.
	 */
	private void sendInitialMsg() {
		String msg = (nodeName.length() + INITIALMSG.length()) + nodeName
				+ INITIALMSG + new java.util.Date();
		sendMsg(new DatagramPacket(msg.getBytes(), msg.length(), groupAddress,
				getPort()));
	}

	/**
	 * Broadcasts a chat message to all members of the multicast group.
	 * 
	 * @param message
	 *            - the message that the node wishes to send.
	 */
	public void sendMsg(String message) {
		String msg;
		if (nodeName.length() > 9) {
			msg = nodeName.length() + nodeName + APPENDMSG + message;
		} else {
			msg = "0" + nodeName.length() + nodeName + APPENDMSG + message;
		}
		sendMsg(new DatagramPacket(msg.getBytes(), msg.length(), groupAddress,
				getPort()));
	}

	public void receiveFileByBytes(byte[] data) {
		int nodeNameLength = Integer.parseInt("" + (char) data[4]
				+ (char) data[5]);
		int fileNameLength = Integer.parseInt(""
				+ (char) data[nodeNameLength + 6]
				+ (char) data[nodeNameLength + 7]);
		FileOutputStream output;
		String fileName = "";
		String nodeName = "";
		File tempFolder = new File("tmp");
		// if the 'tmp' directory does not exist, create it
		if (!tempFolder.exists()) {
			tempFolder.mkdir();
		}
		// read the name of the sender.
		for (int i = 6; i < 6 + nodeNameLength; i++) {
			nodeName += (char) data[i];
		}
		// read the fileName of the received file.
		for (int i = 8 + nodeNameLength; i < 8 + nodeNameLength
				+ fileNameLength; i++) {
			fileName += (char) data[i];
		}
		// read the length of the data of the file.
		int fileLength = Integer.parseInt(""
				+ (char) data[nodeNameLength + fileNameLength + 8]
				+ (char) data[nodeNameLength + fileNameLength + 9]
				+ (char) data[nodeNameLength + fileNameLength + 10]
				+ (char) data[nodeNameLength + fileNameLength + 11]
				+ (char) data[nodeNameLength + fileNameLength + 12]);
		// seperate the data of the file from the header.
		byte[] fileData = new byte[fileLength];
		for (int i = 0; i < fileData.length; i++) {
			fileData[i] = data[i + 8 + fileNameLength + nodeNameLength + 5];
		}
		System.out
				.println(nodeName + " has send you a file named: " + fileName + " Size: " + fileLength + " bytes");
		// create the new file in the 'tmp' directory.
		try {
			output = new FileOutputStream(new File("tmp\\" + fileName));
			output.write(fileData);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void receivePrivateMessage(String[] temp) {
		if (temp[3].equals(nodeName) || temp[0].equals(nodeName)) {
			String privateMessage = "";
			for (int i = 0; i < temp.length; i++) {
				if (i > 3) {
					privateMessage += " " + temp[i];
				}
			}
			if (temp[0].equals(nodeName)) {
				System.out.println("WHISPERED TO " + temp[3] + ":"
						+ privateMessage);
			}
			if (temp[3].equals(nodeName)) {
				System.out.println("WHISPERED BY " + temp[0] + ":"
						+ privateMessage);
			}
		}
	}

	/**
	 * Checks if there are any incoming packets, and writes the content of these
	 * packets to the commandline.
	 */
	public void receiveMsg() {
		byte[] buffer = new byte[300000];
		byte[] fileIndicator = "FILE".getBytes();
		try {
			DatagramPacket pack = new DatagramPacket(buffer, buffer.length);
			socket.receive(pack);
			if (pack.getData() != null) {
				String message = "";
				for (int i = 0; i < pack.getLength(); i++) {
					message += (char) pack.getData()[i];
				}
				byte[] messageBytes = pack.getData();
				// System.out.println(message);
				String[] temp = message.split(" ");
				// System.out.println(Arrays.toString(temp));
				boolean isFile = true;
				for (int i = 0; i < fileIndicator.length; i++) {
					if (!(messageBytes[i] == fileIndicator[i])) {
						isFile = false;
					}
				}
				if (isFile) {
					receiveFileByBytes(pack.getData());
				} else if (!isFile) {
					if (temp[2].equals(CLOSECMD)) {
						close();
					} else if (temp[2].equals(WHISPERCMD)) {
						receivePrivateMessage(temp);
					} else {
						System.out.write(pack.getData(), 2,
								pack.getLength() - 2);
						System.out.println();
					}
				}
			}
		} catch (IOException e) {
			System.err.print("An error occurred while receiving a package.");
		}
	}

	/**
	 * Closes the socket that is connected to the multicast group and notifies
	 * the members of the multicast group.
	 */
	public void close() {
		String msg = (nodeName.length() + CLOSINGMSG.length()) + nodeName
				+ CLOSINGMSG + new java.util.Date();
		sendMsg(new DatagramPacket(msg.getBytes(), msg.length(), groupAddress,
				getPort()));
		try {
			socket.leaveGroup(groupAddress);
		} catch (IOException e) {
			System.err
					.print("Unable to close the connection. Try again later.");
		}

	}

	@Override
	public void run() {
		ListenThread listenThread = new ListenThread(this);
		listenThread.start();
	}
}