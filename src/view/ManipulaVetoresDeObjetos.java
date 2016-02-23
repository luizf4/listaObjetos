package view;

import java.util.InputMismatchException;
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
        
        Funcionario[] vetorFuncionario = new Funcionario[5];
        
        Funcionario funcionario = new Funcionario("", 0, 0);
        
        int opcao = -1;
        int matricula = 0;
        String nome = null;
        
        try {
            do {
                System.out.println("****MENU****\n"
                        + "1 - Inserir Funcionário na proxima posição vazia.\n"
                        + "2 - Procurar Funcionário por Matricula.\n"
                        + "3 - Procurar Funcionário por nome.\n"
                        + "4 - Remover Funcionário por Matricula.\n"
                        + "5 - Alterar o Salário de um Funcionário por Matrícula\n"
                        + "6 - Mostrar todos os Funcionários.\n"
                        + "7 - Encontrar o Maior Salário.\n"
                        + "8 - Finaliza Programa.\n");
                
                opcao = teclado.nextInt();
                
                switch (opcao) {
                    case 1:
                        
                        if (size(vetorFuncionario) != vetorFuncionario.length) {
                            
                            matricula = size(vetorFuncionario) + 10;
                            System.out.println("Nome:");
                            nome = linha.next().toUpperCase();
                            System.out.println("Salario:");
                            double salario = teclado.nextDouble();
                            
                            funcionario = new Funcionario(nome, matricula,
                                    salario);
                            
                            if (inserirFuncionario(vetorFuncionario,
                                    funcionario, matricula) != false) {
                                
                                mostrarFuncionario(vetorFuncionario);
                                
                            } else {
                                
                                System.out.println("\nNão foi possivel inserir "
                                        + "o registro na Lista!\n");
                            }
                            
                        } else {
                            
                            System.out.println("\n****Não existe posição"
                                    + " vazia na lista****\n");
                            
                        }
                        
                        break;
                    case 2:
                        
                        System.out.println("\nDigite o N.º de MATRICULA "
                                + "do Funcionário.\n");
                        matricula = teclado.nextInt();
                        
                        funcionario = procurarMatricula(vetorFuncionario,
                                matricula);
                        
                        if (funcionario == null) {
                            
                            System.out.println("\nNão Encontrou\n");
                        } else {
                            System.out.println(funcionario.toString());
                        }
                        
                        break;
                    case 3:
                        
                        System.out.println("\nDigite o NOME do Funcionário.\n");
                        nome = linha.next().toUpperCase();
                        
                        matricula = procurarNome(vetorFuncionario, nome);
                        
                        if (matricula == -1) {
                            
                            System.out.println("\nNão Encontrou\n");
                            
                        } else {
                            
                            System.out.println("\nO Funcionário " + nome
                                    + " está registrado na matricula: "
                                    + matricula + " !!!\n");
                            
                        }
                        
                        break;
                    case 4:
                        
                        System.out.println("\nDigite a MATRICULA para REMOVER "
                                + "um Funcionário.\n");
                        matricula = teclado.nextInt();
                        
                        removerFuncionario(vetorFuncionario, matricula);
                        
                        break;
                    case 5:
                        
                        System.out.println("\nDigite a MATRICULA para ALTERAR o "
                                + "SALÁRIO de um Funcionário.\n");
                        matricula = teclado.nextInt();
                        System.out.println("\nDigite o SALÁRIO.\n");
                        double salario = teclado.nextDouble();
                        
                        if (alterarSalario(vetorFuncionario, matricula,
                                salario) == false) {
                            System.out.println("Não alterou");
                        }
                        
                        break;
                    case 6:
                        
                        mostrarFuncionario(vetorFuncionario);
                        
                        break;
                    case 7:
                        
                        System.out.println(encontrarMaiorSalario(vetorFuncionario));
                        
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

    /**
     * Método que retorna a quantidade de registros.
     *
     * @param funcVetor
     * @return
     */
    public static int size(Funcionario[] funcVetor) {
        
        int cont = 0;
        
        while (cont < funcVetor.length && funcVetor[cont] != null) {
            
            cont++;
            
        }
        
        return cont;
    }

    /**
     * método para inserir o Funcionário passando como parâmetro o Vetor, o
     * funcionário e a posiçao, que é obtida pelo métodos size.
     *
     * @param vetFunc
     * @param f
     * @param posicao
     */
    public static boolean inserirFuncionario(Funcionario[] vetFunc,
            Funcionario f, int posicao) {
        
        if (size(vetFunc) < vetFunc.length) {
            
            if (posicao < size(vetFunc)) {
                
                for (int i = size(vetFunc); i < posicao; i++) {
                    
                    vetFunc[i] = vetFunc[i - 1];
                    
                }
                
            } else if (posicao > size(vetFunc)) {
                
                posicao = size(vetFunc);
                
            }
            vetFunc[posicao] = f;
            
            return true;
            
        }
        
        return false;
    }

    /**
     * Método que mostra todos os funcionarios
     *
     * @param vetFuncionario
     */
    public static void mostrarFuncionario(Funcionario[] vetFuncionario) {
        
        for (int i = 0; i < size(vetFuncionario); i++) {
            
            System.out.println("Funcionário " + vetFuncionario[i]);
            
        }
        
    }

    /**
     * Método para procurar o funcionario pela matricula.
     *
     * @param vetFuncionario
     * @param matricula
     * @return
     */
    public static Funcionario procurarMatricula(Funcionario[] vetFuncionario,
            int matricula) {
        
        Funcionario funcionario = new Funcionario("", 0, 0);
        
        for (int i = 0; i < size(vetFuncionario); i++) {
            
            if (vetFuncionario[i].getMatricula() == matricula) {
                
                funcionario.setMatricula(vetFuncionario[i].getMatricula());
                funcionario.setNome(vetFuncionario[i].getNome());
                funcionario.setSalario(vetFuncionario[i].getSalario());
                
                return funcionario;
            }
            
        }
        
        return null;
    }

    /**
     * Método que retorna a matricula procurando o funcionário pelo nome.
     *
     * @param vetFuncionario
     * @param nome
     * @return
     */
    public static int procurarNome(Funcionario[] vetFuncionario, String nome) {
        
        for (int i = 0; i < size(vetFuncionario); i++) {
            
            if (vetFuncionario[i].getNome().equals(nome)) {
                
                int matricula = vetFuncionario[i].getMatricula();
                
                return matricula;
            }
            
        }
        
        return -1;
    }

    /**
     * Método remove o Funcionario passando a matricula como parâmetro.
     *
     * @param vetFuncionario
     * @param matricula
     * @return
     */
    public static Funcionario removerFuncionario(Funcionario[] vetFuncionario,
            int matricula) {
        
        for (int i = 0; i < size(vetFuncionario) - 1; i++) {
            
            if (vetFuncionario[i].getMatricula() == matricula) {
                
                vetFuncionario[i] = vetFuncionario[i + 1];
                
            }
            
        }
        vetFuncionario[size(vetFuncionario) - 1] = null;
        
        return null;
        
    }

    /**
     * Método que altera o salario do Funcionário buscando pela matricula.
     *
     * @param vetFuncionario
     * @param matricula
     * @param novoSalario
     * @return
     */
    public static boolean alterarSalario(Funcionario[] vetFuncionario,
            int matricula, double novoSalario) {
        
        Funcionario funcionario = new Funcionario();
        
        funcionario = procurarMatricula(vetFuncionario, matricula);
        
        if (novoSalario > 0) {
            
            for (int i = 0; i < vetFuncionario.length; i++) {
                
                if (vetFuncionario[i].getMatricula() == funcionario.getMatricula()) {
                    
                    vetFuncionario[i].setSalario(novoSalario);
                    
                    return true;
                }
                
            }
        }
        
        return false;
    }

    /**
     * Método para encontrar o maior salário entre os Funcionários.
     *
     * @param vetFuncionario
     * @return
     */
    public static double encontrarMaiorSalario(Funcionario[] vetFuncionario) {
        
        Funcionario funcionario = vetFuncionario[0];
        
        for (int i = 0; i < size(vetFuncionario); i++) {
            
            if (funcionario.getSalario() < vetFuncionario[i + 1].getSalario()) {
                
                funcionario = vetFuncionario[i + 1];
            }
            return funcionario.getSalario();
            
        }
        
        return 0.0;
    }
}
