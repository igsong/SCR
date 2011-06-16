/**
 * <copyright>
 * </copyright>
 *
 * $Id: InteractionTest.java,v 1.1 2011-02-21 04:16:36 igsong Exp $
 */
package kr.ac.kaist.se.interaction.idl.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import kr.ac.kaist.se.interaction.idl.IdlFactory;
import kr.ac.kaist.se.interaction.idl.Interaction;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Interaction</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InteractionTest extends TestCase {

	/**
	 * The fixture for this Interaction test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Interaction fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InteractionTest.class);
	}

	/**
	 * Constructs a new Interaction test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Interaction test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Interaction fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Interaction test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Interaction getFixture() {
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
		setFixture(IdlFactory.eINSTANCE.createInteraction());
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

} //InteractionTest
