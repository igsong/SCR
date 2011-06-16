/**
 * <copyright>
 * </copyright>
 *
 * $Id: IdlAllTests.java,v 1.1 2011-02-21 04:16:36 igsong Exp $
 */
package kr.ac.kaist.se.interaction.idl.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Idl</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class IdlAllTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new IdlAllTests("Idl Tests");
		suite.addTest(IdlTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdlAllTests(String name) {
		super(name);
	}

} //IdlAllTests
