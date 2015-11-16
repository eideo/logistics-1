package org.module.client.BL.Ticket;

import org.module.client.businesslogic.ticketbl.OutBoundController;
import org.module.client.businesslogicservice.ticketBLservice.OutBoundBLService;

import junit.framework.TestCase;

public class OutBoundManageTest extends TestCase {
	private OutBoundBLService outBound;
	
	protected void setUp() throws Exception {
		super.setUp();
		outBound = new OutBoundController(new OutBoundMock());
	}
	
	public void testcreateTicket(){
		assert(outBound.createTicket("01","2015","beijing","01","10086","100"));
	}
}
