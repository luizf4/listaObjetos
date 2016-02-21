package view;

import java.util.Scanner;
import model.Funcionario;

/**
 * @author Luiz Fernando de Souza Matricula: 225272 OD - Prof.ª Silvia Brunini
 * ADS - Polo Sorocaba
 */
public class ManipulaVetoresDeObjetos {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Scanner linha = new Scanner(System.in);

        Funcionario[] vetorFuncionario = new Funcionario[3];

        Funcionario funcionario = new Funcionario("", 0, 0);

        int opcao = -1;
        int matricula = 0;

        try {
            do {
                System.out.println("****MENU****\n"
                        + "1 - Inserir Funcionário na proxima posição vazia.\n"
                        + "2 - Procurar por um funcionário por matricula.\n"
                        + "3 - Procurar por um funcionário por nome.\n"
                        + "4 - Remover um funcionário por matricula.\n"
                        + "5 - Alterar o salário de um funcionário por matrícula\n"
                        + "6 - Mostrar todos os funcionários.\n"
                        + "7 - Encontrar o maior salário.\n"
                        + "8 - Finaliza Programa.\n");

                opcao = teclado.nextInt();

                switch (opcao) {
                    case 1:

                        if (size(vetorFuncionario) != vetorFuncionario.length) {

                            matricula = size(vetorFuncionario);
                            System.out.println("Nome:");
                            String nome = linha.next();
                            System.out.println("Salario:");
                            double salario = teclado.nextDouble();

                            funcionario = new Funcionario(nome, matricula, salario);

                            inserir(vetorFuncionario, funcionario, matricula);

                            mostrar(vetorFuncionario);

                        } else {

                            System.out.println("\n****Não existe posição"
                                    + " vazia na lista****\n");

                        }

                        break;
                    case 2:

                        System.out.println(size(vetorFuncionario));

                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:

                        mostrar(vetorFuncionario);

                        break;
                    case 7:
                        break;
                    case 8:

                        System.out.println("\nFim do Programa!");

                        break;
                    default:
                        System.out.println("\nOpção Inválida.");

                }
                System.out.println();
            } while (opcao != 8);
        } catch (Exception ex) {

            System.out.println("\nErro : "
                    + ex.getMessage());
            ex.printStackTrace();

        }

        teclado.close();
        linha.close();

    }

    public static int size(Funcionario[] funcVetor) {

        int cont = 0;

        while (cont < funcVetor.length && funcVetor[cont] != null) {

            cont++;

        }

        return cont;
    }

    public static void inserir(Funcionario[] vetFunc, Funcionario f, int posicao) {

        if (size(vetFunc) < vetFunc.length) {

            if (posicao < size(vetFunc)) {

                for (int i = size(vetFunc); i < posicao; i++) {

                    vetFunc[i] = vetFunc[i - 1];

                }

            } else if (posicao > size(vetFunc)) {

                posicao = size(vetFunc);

            }
            vetFunc[posicao] = f;

        }
    }

    public static void inserir(Funcionario[] vetorFunc, Funcionario f) {

        if (size(vetorFunc) < vetorFunc.length) {

            vetorFunc[size(vetorFunc)] = f;

        }

    }

    public static void mostrar(Funcionario[] vetorFunc) {

        for (int i = 0; i < size(vetorFunc); i++) {

            System.out.println("Funcionário " + vetorFunc[i]);

        }

    }

}
