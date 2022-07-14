import java.util.*;

public class PrimeGap {

    public static void main(String[] args){

        // Create and populate prime numbers - Tree set ordered
        Set<Integer> primeSet = new TreeSet<>();
        for(int i = 2; i < 100; i++){
            if(PrimeFinder.isPrime(i)){
                primeSet.add(i);
            }
        }

        HashMap<Integer, Integer> primeGaps = new HashMap<Integer, Integer>();

        Iterator<Integer> iterator = primeSet.iterator();

        while(iterator.hasNext()){
            // Store value and then remove from Set
            Integer value = iterator.next();
            iterator.remove();

            Iterator<Integer> iterator1 = primeSet.iterator();
            // Iterate over remaining
            while(iterator1.hasNext()){

                // Compute gap of value and remaining
                Integer next = iterator1.next();
                Integer gap = next - value;

                // Populate gap hashmap
                if(primeGaps.containsKey(gap)){
                    primeGaps.put(gap, primeGaps.get(gap) + 1);
                } else {
                    primeGaps.put(gap, 1);
                }
            }
        }
        // Print all pairs in hashmap
        primeGaps.forEach((i, j) -> System.out.println(i + " | " + j));
    }
}

