using System.Numerics;
using System.Collections.Generic;
using System;
using System.IO;
namespace TEI
{
    internal class Program
    {
        private static Stack<BigInteger> s=new Stack<BigInteger>();
        private static string code="";
        static void Main(string[] args)
        {
            if(args.Length == 0)
            {
                int c;
                while ((c = Console.Read()) != -1)
                {
                    code += Convert.ToChar(c);
                }
            }
            else
            {
                code = File.ReadAllText(args[0]);
            }
            foreach(char i in code)
            {
                if (i == '+')
                {
                    BigInteger a, b;
                    a=s.Pop();
                    b=s.Pop();
                    s.Push(b + a);
                }else if (i == '-')
                {
                    BigInteger a, b;
                    a = s.Pop();
                    b = s.Pop();
                    s.Push(b - a);
                }else if (i == '*')
                {
                    BigInteger a, b;
                    a = s.Pop();
                    b = s.Pop();
                    s.Push(b * a);
                }else if (i == '.')
                {
                    BigInteger a = s.Pop();
                    Console.Write(a.ToString()+" ");
                }
                else if (i == '!')
                {
                    BigInteger a = s.Pop();
                    Console.Write((char)a);
                }else if (i == ',')
                {
                    s.Push(BigInteger.Parse(Console.ReadLine()));
                }else if (i == '?')
                {
                    s.Push(BigInteger.Parse(Convert.ToString((Console.Read()+256)%256)));
                }else if(i>='0' && i <= '9')
                {
                    s.Push(i - '0');
                }
                else
                {
                    s.Push(BigInteger.Parse(Convert.ToString(Convert.ToUInt16(i))));
                }
            }
        }
    }
}