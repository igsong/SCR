/**
 * <copyright>
 * </copyright>
 *
 * $Id: JoinTest.java,v 1.1 2011-02-21 04:16:37 igsong Exp $
 */
package kr.ac.kaist.se.interaction.idl.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import kr.ac.kaist.se.interaction.idl.IdlFactory;
import kr.ac.kaist.se.interaction.idl.Join;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Join</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class JoinTest extends TestCase {

	/**
	 * The fixture for this Join test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Join fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(JoinTest.class);
	}

	/**
	 * Constructs a new Join test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoinTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Join test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Join fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Join test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Join getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(IdlFactory.eINSTANCE.createJoin());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //JoinTest
