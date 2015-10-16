
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author prabh
 */
public class CandidateList {

    //Data structure used is a TreeMap
    private Map tree = new TreeMap();

    private static CandidateList candidateList = new CandidateList();

    //Default Constructor
    private CandidateList() {
    }

    public static CandidateList getInstance() {
        return candidateList;
    }

    public boolean add(Candidate c) {
        if (tree.containsKey(c.getName())) {
            return false;
        } else {
            tree.put(c.getName(), c);
            return true;
        }
    }

    /**
     * Deletes a spy from the list
     *
     * @param s - Spy object to be deleted
     * @return - Object which is deleted
     */
    public Object delete(Candidate c) {
        return tree.remove(c.getName());
    }

    public Candidate get(String userID) {
        return (Candidate) tree.get(userID);
    }

    /**
     * Returns all the spies in the list
     *
     * @return - Collection of values of spies
     */
    public Collection getList() {
        return tree.values();
    }

    /**
     * Returns simple string representation of all spies in the list
     *
     * @return - simple string
     */
    public String toString() {

        StringBuffer representation = new StringBuffer();
        Collection c = getList();
        Iterator sl = c.iterator();
        representation.append("data: {");
        while (sl.hasNext()) {
            Candidate cd = (Candidate) sl.next();
            if (sl.hasNext() == false) {

                representation.append("{ id: " + "'" +cd.getId() + "'" +"," + " name: " +"'"+ cd.getName() + "'" +"}");
            } else {

                representation.append("{ id: " +"'" +cd.getId() +"'"+ "," + " name: " + "'" + cd.getName()+ "'" + "},");
            }
        }
        representation.append("}");
        return representation.toString();
    }

}
