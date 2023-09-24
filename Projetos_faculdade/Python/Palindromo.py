palavra=input("Insira uma palavra: ")
azavesso=palavra[::-1]
if azavesso==palavra:
    print(palavra+' é um palindromo')
else:
    print(palavra+' Não é um palindromo')
