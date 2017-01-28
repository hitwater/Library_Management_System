package lms;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Member {
	private int memberID;
    private double balance;  //amount due for resources checked in but not yet paid
    private ArrayList<Resource> checkOuts = new ArrayList<>();  // currently checked out resources

	
	public Member(int memberID) {
		this.memberID = memberID;
	}

	public int getMemberID() {
		return memberID;
	}
    
    /**
     * Updates balance by subtracting the amount.
     * @return new balance.
     */
    public double makePayment(double amount) {
        balance -= amount;
        return balance;
    }
	
	/**
	 * Calculates a new due date from the given start date, based on the length of
	 * time the member is allowed to check out Books.
	 * @param startDate  updated to the new due date.
	 */
	public abstract void calculateNewBookDueDate(Calendar startDate);
	
	/**
	 * Adds a resource to the list of items checked out by this Member
	 * @param resource
	 */
	public void addResource(Resource resource) {
		checkOuts.add(resource);
	}
	
	/**
	 * Removes a resource from the list of items checked out by this Member
	 * @param resource
	 */
	public void removeResource(Resource resource) {
		checkOuts.remove(resource);
	}
	
	/**
	 * Finds the checked out resource with the given ID.  Returns null if not found.
	 * @param resourceID
	 * @return the resource or null
	 */
	public Resource findResource(int resourceID) {
		for (Resource r : checkOuts) {
			if (r.getResourceID()==resourceID)
				return r;
		}
		return null;
	}


}
