import java.util.Scanner;


public class Main
{

	public static void main(String[] args) 
	{
		final int PILE_1ST = 1;
		final int PILE_2ND = 2;
		final int PILE_3RD = 3;
		final int initialCoins = 12;
		int firstPile = initialCoins;
		int secondPile = initialCoins;
		int thirdPile = initialCoins;
		final String NUMBER_OF_COINS = "Wybierz kwadrat liczby monet: ";
		final String REMAINING_COINS = "Pozostałe monety: ";
		final String PILE_ERROR = "ŹLE wybrano zbiór poza zakresem. Wybierz poprawny: ";
		int playerNumber = 1;
		Scanner in = new Scanner(System.in);
		int coinsTaken;
		double x = 0; 

		
		while (firstPile != 0 || secondPile != 0 || thirdPile != 0) 
		{

			System.out.println(REMAINING_COINS + firstPile + ", " + secondPile + ", " + thirdPile);

			int pileTaken = 0;

			
			while (pileTaken != PILE_1ST && pileTaken != PILE_2ND && pileTaken != PILE_3RD) 
			{

				if (playerNumber == 1)
				{
					playerNumber = 0;
				}
				else
				{
					playerNumber = 1;
				}
				
				if (playerNumber == 0) 
				{
					System.out.print("Gracz 1 wybiera zbiór: ");
				} 
				else 
				{
					System.out.print("Gracz 2 wybiera zbiór: ");
				}

				
				while (true) 
				{
					
					while (!in.hasNextInt()) 
					{
						System.out.print(PILE_ERROR);
						in.next(); 
					}

					pileTaken = in.nextInt();
					
					
					if (pileTaken == PILE_1ST && firstPile != 0) 
					{
						break;
					}
							
					if (pileTaken == PILE_2ND && secondPile != 0)
					{
						break;
					}
					if (pileTaken == PILE_3RD && thirdPile != 0)
					{
						break;
					}

					System.out.print(PILE_ERROR);
				}
				
				if (pileTaken > PILE_3RD || pileTaken <= 0) 
				{
					System.out.print(PILE_ERROR);
				}
			}

			
			while (true) 
			{
				System.out.print(NUMBER_OF_COINS);
				
				while (!in.hasNextInt()) 
				{
					System.out.print(PILE_ERROR);
					in.next();
				}
				coinsTaken = in.nextInt();

				if ((pileTaken == PILE_1ST && coinsTaken > firstPile) 
						|| (pileTaken == PILE_2ND && coinsTaken > secondPile)
						|| (pileTaken == PILE_3RD && coinsTaken > thirdPile)) 
				{
					System.out.print("Nie wystarczająca ilość monet w zbiorze ");
					continue;
				}

				x = (double) Math.sqrt(coinsTaken);
				
				if (x != (int) x) 
				{
					System.out.print("ŹLE wybrana liczba monet musi być kwadratem 1-3 ");
					continue;
				} 
				else
				{
					break;
				}
			}

			
			if (pileTaken == PILE_1ST) 
			{
				firstPile -= coinsTaken;
			} 
			else if (pileTaken == PILE_2ND) 
			{
				secondPile -= coinsTaken;
			} 
			else if (pileTaken == PILE_3RD) 
			{
				thirdPile -= coinsTaken;
			}

		}
		System.out.println("Gracz " + (++playerNumber) + " WYGRYWA!");
		in.close();
	}

}
