/**
 * <copyright>
 * </copyright>
 *
 * $Id: SequenceFlowTest.java,v 1.1 2011-02-21 04:16:36 igsong Exp $
 */
package kr.ac.kaist.se.interaction.idl.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import kr.ac.kaist.se.interaction.idl.IdlFactory;
import kr.ac.kaist.se.interaction.idl.SequenceFlow;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Sequence Flow</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SequenceFlowTest extends TestCase {

	/**
	 * The fixture for this Sequence Flow test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceFlow fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SequenceFlowTest.class);
	}

	/**
	 * Constructs a new Sequence Flow test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceFlowTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Sequence Flow test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SequenceFlow fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Sequence Flow test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceFlow getFixture() {
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
		setFixture(IdlFactory.eINSTANCE.createSequenceFlow());
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

} //SequenceFlowTest
