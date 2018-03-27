package ptb2;

public class PTB2Engine {
	private int a;
	private int b;
	private int c;

	public PTB2Engine(int a, int b, int c)

	{

		this.a = a;

		this.b = b;

		this.c = c;

	}

	public String compute()

	{

		String kq = "";

		if (this.a == 0)

		{

			if (this.b == 0)

			{

				if (this.c == 0)

				{

					kq = "Vô số nghiệm";

				}

				else

				{

					kq = "Vô nghiệm";

				}

			}

			else

			{

				kq = "Pt co 1 no x1=" + (-this.c / this.b);

			}

		}

		else

		{

			double delta = this.b * this.b - 4 * this.a * this.c;

			if (delta < 0)

				kq = "Vô nghiệm";

			else if (delta == 0)

				kq = "No kép x1=x2=" + (-this.b / (2 * this.a));

			else

			{

				kq = "x1 = " + ((-this.b - Math.sqrt(delta)) / (2 * this.a));

				kq += "  x2 = " + ((-this.b + Math.sqrt(delta)) / (2 * this.a));

			}

		}

		return kq;

	}

}
