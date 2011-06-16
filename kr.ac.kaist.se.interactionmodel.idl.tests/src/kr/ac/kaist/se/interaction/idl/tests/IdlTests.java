/**
 * <copyright>
 * </copyright>
 *
 * $Id: IdlTests.java,v 1.1 2011-02-21 04:16:37 igsong Exp $
 */
package kr.ac.kaist.se.interaction.idl.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>idl</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class IdlTests extends TestSuite {

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
		TestSuite suite = new IdlTests("idl Tests");
		suite.addTestSuite(ChoreographyTest.class);
		suite.addTestSuite(ParticipantTest.class);
		suite.addTestSuite(InteractionTest.class);
		suite.addTestSuite(SequenceFlowTest.class);
		suite.addTestSuite(BranchTest.class);
		suite.addTestSuite(JoinTest.class);
		suite.addTestSuite(InitialTest.class);
		suite.addTestSuite(FinalTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdlTests(String name) {
		super(name);
	}

} //IdlTests
