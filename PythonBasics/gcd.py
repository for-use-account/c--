def GCD(a,b):
    if a == 0:
        return b
    else:
        return GCD(b,a%b)

a = int(input("Enter the first number: "))
b = int(input("Enter the second number: "))
print("The GCD of",a,"and",b,"is",GCD(a,b))
