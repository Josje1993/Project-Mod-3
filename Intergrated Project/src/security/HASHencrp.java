package security;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HASHencrp {

	 /**
     * Commonly-used hashing algorithms.
     */
    public enum Algorithm {
        MD2("MD2", "The MD2 message digest algorithm as defined in RFC 1319"),
        MD5("MD5", "The MD5 message digest algorithm as defined in RFC 1321"),
        SHA_1("SHA-1", "The Secure Hash Algorithm, as defined in Secure Hash Standard, NIST FIPS 180-1"),
        SHA_256(
                "SHA-256",
                "New hash algorithms for which the draft Federal Information Processing Standard 180-2, "
                + "Secure Hash Standard (SHS) is now available.  SHA-256 is a 256-bit hash function intended to provide 128 bits of "
                + "security against collision attacks."),
        SHA_384(
                "SHA-384",
                "New hash algorithms for which the draft Federal Information Processing Standard 180-2, "
                + "Secure Hash Standard (SHS) is now available.  A 384-bit hash may be obtained by truncating the SHA-512 output."),
        SHA_512(
                "SHA-512",
                "New hash algorithms for which the draft Federal Information Processing Standard 180-2, "
                + "Secure Hash Standard (SHS) is now available.  SHA-512 is a 512-bit hash function intended to provide 256 bits of security.");
        private String name;
        private String description;

        private Algorithm( String name,
                           String description ) {
            this.name = name;
            this.description = description;
        }

        public String digestName() {
            return this.name;
        }

        public String description() {
            return this.description;
        }

        @Override
        public String toString() {
            return digestName();
        }
    }

    /**
     * Get the hash of the supplied content, using the supplied digest algorithm.
     * 
     * @param algorithm the hashing function algorithm that should be used
     * @param content the content to be hashed; may not be null
     * @return the hash of the contents as a byte array
     * @throws NoSuchAlgorithmException if the supplied algorithm could not be found
     * @throws IllegalArgumentException if the algorithm is null
     */
    public static byte[] getHash( Algorithm algorithm,
                                  byte[] content ) throws NoSuchAlgorithmException {

        return getHash(algorithm.digestName(), content);
    }

    /**
     * Get the hash of the supplied content, using the supplied digest algorithm.
     * 
     * @param algorithm the hashing function algorithm that should be used
     * @param file the file containing the content to be hashed; may not be null
     * @return the hash of the contents as a byte array
     * @throws NoSuchAlgorithmException if the supplied algorithm could not be found
     * @throws IllegalArgumentException if the algorithm is null
     * @throws IOException if there is an error reading the file
     */
    public static byte[] getHash( Algorithm algorithm,
                                  File file ) throws NoSuchAlgorithmException, IOException {

        return getHash(algorithm.digestName(), file);
    }

    /**
     * Get the hash of the supplied content, using the supplied digest algorithm.
     * 
     * @param algorithm the hashing function algorithm that should be used
     * @param stream the stream containing the content to be hashed; may not be null
     * @return the hash of the contents as a byte array
     * @throws NoSuchAlgorithmException if the supplied algorithm could not be found
     * @throws IllegalArgumentException if the algorithm is null
     * @throws IOException if there is an error reading the stream
     */
    public static byte[] getHash( Algorithm algorithm,
                                  InputStream stream ) throws NoSuchAlgorithmException, IOException {

        return getHash(algorithm.digestName(), stream);
    }

    /**
     * Get the hash of the supplied content, using the digest identified by the supplied name.
     * 
     * @param digestName the name of the hashing function (or {@link MessageDigest message digest}) that should be used
     * @param content the content to be hashed; may not be null
     * @return the hash of the contents as a byte array
     * @throws NoSuchAlgorithmException if the supplied algorithm could not be found
     */
    public static byte[] getHash( String digestName,
                                  byte[] content ) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(digestName);
        assert digest != null;
        return digest.digest(content);
    }

    /**
     * Get the hash of the supplied content, using the digest identified by the supplied name.
     * 
     * @param digestName the name of the hashing function (or {@link MessageDigest message digest}) that should be used
     * @param file the file whose content is to be hashed; may not be null
     * @return the hash of the contents as a byte array
     * @throws NoSuchAlgorithmException if the supplied algorithm could not be found
     * @throws IOException if there is an error reading the file
     */
    public static byte[] getHash( String digestName,
                                  File file ) throws NoSuchAlgorithmException, IOException {

        MessageDigest digest = MessageDigest.getInstance(digestName);
        assert digest != null;
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        boolean error = false;
        try {
            int bufSize = 1024;
            byte[] buffer = new byte[bufSize];
            int n = in.read(buffer, 0, bufSize);
            int count = 0;
            while (n != -1) {
                count += n;
                digest.update(buffer, 0, n);
                n = in.read(buffer, 0, bufSize);
            }
        } catch (IOException e) {
            error = true;
            throw e;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                if (!error) throw e;
            }
        }
        return digest.digest();
    }

    /**
     * Get the hash of the supplied content, using the digest identified by the supplied name. Note that this method never closes
     * the supplied stream.
     * 
     * @param digestName the name of the hashing function (or {@link MessageDigest message digest}) that should be used
     * @param stream the stream containing the content to be hashed; may not be null
     * @return the hash of the contents as a byte array
     * @throws NoSuchAlgorithmException if the supplied algorithm could not be found
     * @throws IOException if there is an error reading the stream
     */
    public static byte[] getHash( String digestName,
                                  InputStream stream ) throws NoSuchAlgorithmException, IOException {

        MessageDigest digest = MessageDigest.getInstance(digestName);
        assert digest != null;
        int bufSize = 1024;
        byte[] buffer = new byte[bufSize];
        int n = stream.read(buffer, 0, bufSize);
        int count = 0;
        while (n != -1) {
            count += n;
            digest.update(buffer, 0, n);
            n = stream.read(buffer, 0, bufSize);
        }
        return digest.digest();
    }
    
    public static void main(String[] args){
    	HASHencrp hash = new HASHencrp();
    	
    }
}
