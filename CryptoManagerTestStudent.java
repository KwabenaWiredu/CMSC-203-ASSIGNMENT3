import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CryptoManagerTestStudent {
	CryptoManager cryptoManager;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("HELLO"));
		assertTrue(CryptoManager.isStringInBounds("FATHER TIME"));
	}

	@Test
	public void testCaesarEncryption() {
		assertEquals("GDG", CryptoManager.caesarEncryption("DAD", 3));
		assertEquals("Dterw", CryptoManager.caesarEncryption(" PANS", 100));
	}

	@Test
	public void testBellasoEncryption() {
		assertEquals("INgKH_f", CryptoManager.bellasoEncryption("FATHERS", "CMSC"));
		assertEquals("D[bF88U-", CryptoManager.bellasoEncryption("ANOTHER ", "CMS203"));
	}

	@Test
	public void testCaesarDecryption() {
		assertEquals("DAD", CryptoManager.caesarDecryption("GDG", 3));
		assertEquals(" PANS", CryptoManager.caesarDecryption("#SDQV", 3));
	}

	@Test
	public void testBellasoDecryption() {
		assertEquals("ABCD", CryptoManager.bellasoDecryption("DOVG", "CMS"));
		assertEquals("CDATY", CryptoManager.bellasoDecryption("DFBVZ", "AB"));
	}

}
