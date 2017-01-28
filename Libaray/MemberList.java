package lms;

import java.util.ArrayList;

/**
 * Represents a list of the members of the Library.
 *
 * @author Guiming Huang
 *
 */
public class MemberList  {
	
	private ArrayList<Member> memberList =
            new ArrayList<Member>();        // list of members
	
	/**
	 * Default constructor, creates an empty member list
	 */
	public MemberList() {
	}
    
	/**
	 * Given a member instance, validates the values and
	 * adds it to the end of the memberList.
     * @param member the person to validate and add to the memberList
	 */
	public boolean addMember(Member member) {
        
        //check for uniqueness
        int index = searchList(member.getMemberID());
        
        // if  found, return false
        if (index!=-1) {
            System.out.println("Unable to add member, member ID is not unique.");
            return false;
        }
        
        else {
            memberList.add(member);
            return true;
        }
    }
    
    
    
    /**
     * removes a member from the memberList based on the given memberID.
     * If no member with that id is in the memberList, returns false.
     * @param memberID the id of the member to be removed
     */
    public boolean removeMember(int memberID) {
        
        // find the resourceID in the list
        int index = searchList(memberID);
        
        // if found, remove it, else output message
        if (index == -1) {
            System.out.println("Unable to remove member, member ID not found");
            return false;
        } else {
            memberList.remove(index);
            return true;
        }
    }
    
    /**
     * Finds a member in the memberList based on the given memberID.
     * If no member with that id is in the memberID, returns null.
     * @param memberID the id of the member to be found
     */
    public Member findMember(int memberID) {
        // find the resourceID in the list
        int index = searchList(memberID);
        if (index == -1)
            return null;
        return memberList.get(index);
    }
    
    /**
     * Uses linear search to find a certain element (value) in the list.
     * @param value the target value to search for
     * @return the index of the item in the list, or -1 if not found
     */
    private int searchList ( int value) {
        // iterate over the list until found
        for (int i=0; i<memberList.size(); i++) {
            // check if the current member is the one we're looking for
            if (memberList.get(i).getMemberID() == value)
                return i;
        }
        return -1;
    }
}