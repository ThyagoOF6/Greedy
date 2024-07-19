public class Program
{
    public static void Main(string[] args)
    {
        if(LemonadeChange(new int[]{5, 5, 5, 10, 20}) == true)
            Console.WriteLine("Verdadeiro");
        else
            Console.WriteLine("Falso");

        if(LemonadeChange(new int[]{5, 5, 10, 10, 20}) == true)
            Console.WriteLine("Verdadeiro");
        else
            Console.WriteLine("Falso");
    }
    public static bool LemonadeChange(int[] bills)
    {
        // Maps the count of each bill value we have
        Dictionary<int, int> myBills = new Dictionary<int, int> {
            {5, 0},
            {10, 0},
            {20, 0}
        };

        foreach (var bill in bills)
        {
            if (myBills.ContainsKey(bill))
            {
                myBills[bill]++;
            }

            int change = bill - 5;

            // Attempts to give change, starting with the largest bill values
            foreach (var value in new int[] { 20, 10, 5 })
            {
                while (change >= value && myBills[value] > 0)
                {
                    myBills[value]--;
                    change -= value;
                }
            }

            if (change > 0)
            {
                return false;
            }
        }

        return true;
    }
}
