/**
 * <copyright>
 * </copyright>
 *
 * $Id: InitialTest.java,v 1.1 2011-02-21 04:16:37 igsong Exp $
 */
package kr.ac.kaist.se.interaction.idl.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import kr.ac.kaist.se.interaction.idl.IdlFactory;
import kr.ac.kaist.se.interaction.idl.Initial;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Initial</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InitialTest extends TestCase {

	/**
	 * The fixture for this Initial test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Initial fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InitialTest.class);
	}

	/**
	 * Constructs a new Initial test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitialTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Initial test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Initial fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Initial test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Initial getFixture() {
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
		setFixture(IdlFactory.eINSTANCE.createInitial());
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

} //InitialTest
