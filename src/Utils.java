import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;
/**
 * Implements sorting for hashmap
 * @author Anim Malvat
 *
 */
public class Utils {
	// function to sort hash map by values 
    public static HashMap<String, Float> sortByValue(HashMap<String, Float> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Float> > list = 
               new LinkedList<Map.Entry<String, Float> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Float> >() { 
            public int compare(Map.Entry<String, Float> o1,  
                               Map.Entry<String, Float> o2) 
            { 
                return (o2.getValue()).compareTo(o1.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hash map  
        HashMap<String, Float> temp = new LinkedHashMap<String, Float>(); 
        for (Map.Entry<String, Float> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
}
