import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by biplabkumardas on 1/11/17.
 */
class LinkList {
    public Link first;
    public int nelms;

    // default constructor
    public LinkList(){
        first = null;
        nelms = 0;
    }

    // for inserting elements
    public void inseertfirst(int d1, double d_1){
        Link nlink = new Link(d1, d_1);
        nlink.next = first;
        first = nlink;
        nelms = nelms + 1;
    }

    // specify the position where it needs to added
    // in this case data value shows as key value
    public void insertAtpos(int key, double k2){
        Link cur = first;
        Link prev = first;
        while(cur.idata != key){
            prev = cur;
            cur = cur.next;
        }
        // now prev has the Link before which the new Link needs
        // to be inserted
        Link nlink = new Link(key, k2);
        nlink.next = prev.next;
        prev.next = nlink;
        nelms = nelms + 1;
    }
    // deleting a node from the middle when only access to the particular
    // Link is given
    public void deleteMiddle(int key, double k){
        Link find = first;
        while(find.idata != key){
            find = find.next;
        }
        Link next = find.next;
        find.idata = next.idata;
        find.next = next.next;
    }




    // deleting a middle node, given only access to its middle node
    // from the given node only we have to delte the node]
    public void delete(int key){
        Link cur = first;
        Link prev = first;
        while(cur.idata != key){
            prev = cur;
            cur = cur.next;
        }
        // now prev has the Link before which the new Link needs
        // to be inserted
        prev.next = cur.next;
        nelms = nelms - 1;
    }

    // removing duplicate elements from the LinkList
    public void removeDup() {
        Link cur = first;
        while(cur != null){
            Link prev = cur;
            while(prev.next != null) {
                if (prev.next.idata == cur.idata) {
                    prev.next = prev.next.next;
                }
                else{
                    prev = prev.next;
                }
            }
            cur = cur.next;
        }
        // done with sorting and removing the duplciate element or links
        // since now the Links are there in hashset data structure we need
        // to move them to the Link structure
    }

    // same program for removing duplicate elements using
    // hashset where during each iteration we compare and if there
    // is no match we add it to the hashset otherwise we move on to the
    // next link
    public void removeDupUsingHashset(){
        HashSet<Integer> hs = new HashSet<>();
        Link nlink  = first;
        Link prev = null;
        while(nlink != null){
            if(hs.contains(nlink.idata)){
                nlink = nlink.next;
            }
            else{
                hs.add(nlink.idata);
                prev = nlink;
            }
            nlink = nlink.next;
        }
        System.out.println(hs);
    }


    public Link kthelement(int k){
        Link cur = first;
        int temp = nelms;
        int count = nelms - k;
        while(temp != count){
            temp = temp -1 ;
            cur = cur.next;
        }
        return cur;
    }







    // for displaying all the Links with their values
    // keep movingg up until we encounter null;
    public void displayal(){
        Link cur = first;
        while(cur != null){
            System.out.println(cur.idata + " " + cur.ddata);
            cur = cur.next;
        }
        System.out.println("Total Link in the Link list -- > " + nelms);
        System.out.println(" ");
    }
}
