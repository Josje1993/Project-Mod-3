package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Date;

/**
 * Class that is responsible for sending an initial message when a node joins
 * the multicast group. Keeps listening for new messages and provides the
 * functionality to send messages to the multicast group
 * 
 * @author Joshua de Bie
 * 
 */
public class Messager implements Runnable {
	byte[] buffer = new byte[300];
	MulticastSocket socket;
	int multicastPort;
	InetAddress groupAddress;
	String IP_Address;
	String nodeName;
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
		if (nodeName.length() > 20) {
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
	 * Checks if there are any incoming packets, and writes the content of these
	 * packets to the commandline.
	 */
	public void receiveMsg() {
		try {
			DatagramPacket pack = new DatagramPacket(buffer, buffer.length);
			socket.receive(pack);
			if (pack.getData() != null) {
				String message = "";
				int senderNameLength = Integer.parseInt(""
						+ (char) pack.getData()[0] + (char) pack.getData()[1]);
				for (int i = 2; i < pack.getLength(); i++) {
					message += (char) pack.getData()[i];
				}
				String[] temp = message.split(" ");
				//System.out.println(Arrays.toString(temp));
				// Check if the message is intended to close the current client;
				if (message.equals(CLOSECMD)) {
					close();
				}
				// Check if the received message is intended to be private;
				else if (temp[2].equals(WHISPERCMD)) {
					if (temp[3].equals(nodeName) || temp[0].equals(nodeName)) {
						String privateMessage = "";
						for (int i = 0; i < temp.length; i++) {
							if (i > 3) {
								privateMessage += " " + temp[i];
							}
						}
						if (temp[0].equals(nodeName)) {
							System.out.println("WHISPERED TO "+ temp[3] + ":" + privateMessage);
						} 
						if (temp[3].equals(nodeName)) {
							System.out.println("WHISPERED BY " + nodeName + ":" + privateMessage);
						}
					}
				} else {
					System.out.write(pack.getData(), 2, pack.getLength() - 2);
					System.out.println();
				}
			}

		} catch (IOException e) {
			System.err.print("An error occurred while receiving a package.");
		}
	}

	/**
	 * Closes the socket that is connected to the multicast group.
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
	 * Broadcasts a message to all members of the multicast group.
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
				getPort()), 25);
	}

	@Override
	public void run() {
		ListenThread listenThread = new ListenThread(this);
		listenThread.start();
	}
}