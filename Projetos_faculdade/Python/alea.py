import random
z=1
while z==1:
    print('-'*30)
    print('Programa de números aleátorios')
    print('-'*30)
    x = int(input('insira um valor de partida: '))
    y = int(input('insira o valor limite: '))
    a = random.randint(x, y)
    print('seu Número aleátorio é ',a)
    print('')
    z =input('Digite 1 para calcular novamente ou 2 para fechar: ')
