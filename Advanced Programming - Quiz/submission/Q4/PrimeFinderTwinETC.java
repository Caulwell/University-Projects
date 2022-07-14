public class PrimeFinderTwinETC {

    public static void findTwinPrimesETC(int[] primes, int numPrimes){
        System.out.println(" ");
        System.out.println("Twin Primes: ");

        for(int i = 1; i < numPrimes; i++){
            for(int j = 0; j < i; j++){
                if(primes[i] - primes[j] == 2){
                    System.out.println("(" + primes[i] + "," + primes[j] + ")");
                }
            }
        }

        System.out.println(" ");
        System.out.println("Cousin Primes: ");

        for(int i = 1; i < numPrimes; i++){
            for(int j = 0; j < i; j++){
                if(primes[i] - primes[j] == 4){
                    System.out.println("(" + primes[i] + "," + primes[j] + ")");
                }
            }
        }

        System.out.println(" ");
        System.out.println("Sexy Primes: ");

        for(int i = 1; i < numPrimes; i++){
            for(int j = 0; j < i; j++){
                if(primes[i] - primes[j] == 6){
                    System.out.println("(" + primes[i] + "," + primes[j] + ")");
                }
            }
        }
    }

    public static void main(String[] args){
        if (args.length < 1) {
            System.out.println("usage: java PrimeFinder <max-range>");
            return;
        }

        int maxRange = Integer.parseInt(args[0]);

        int[] primes = new int[maxRange];
        int numPrimes = 0;

        for (int i=2; i<= maxRange; i++) {
            if (PrimeFinder.isPrime(i)) {
                primes[numPrimes] = i;
                numPrimes ++;
            }
        }

        findTwinPrimesETC(primes, numPrimes);



    }
}
