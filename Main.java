import java.util.List;
import java.util.Scanner;

import br.ceub.controller.LivroController;
import br.ceub.model.Livro;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== SISTEMA DE GERENCIAMENTO DE BIBLIOTECA =====\n");
        

                Scanner sc = new Scanner(System.in);
                LivroController livroController = new LivroController();

                int opcao;

                do {
                    System.out.println("1 - Cadastrar Livro");
                    System.out.println("2 - Listar Livros");
                    System.out.println("3 - Buscar Livro por ID");
                    System.out.println("4 - Remover Livro");
                    System.out.println("0 - Sair");
                    System.out.print("Escolha: ");
                
                    opcao = sc.nextInt();
                    sc.nextLine();
                
                    switch (opcao) {

                        case 1:
                            System.out.print("Nome: ");
                            String nome = sc.nextLine();

                            System.out.print("Autor: ");
                            String autor = sc.nextLine();

                            System.out.print("Edição: ");
                            int edicao = sc.nextInt();

                            System.out.print("Quantidade: ");
                            int quantidade = sc.nextInt();

                            Livro livro = new Livro(0, nome, autor, edicao, quantidade);

                            livroController.cadastrar(livro);
                            System.out.println("Livro cadastrado!");
                            break;

                        case 2:
                            List<Livro> livros = livroController.listarTodos();

                            for (Livro l : livros) {
                                System.out.println(l);
                            }
                            break;

                        case 3:
                            System.out.print("Digite o ID: ");
                            int id = sc.nextInt();

                            Livro encontrado = livroController.buscarPorId(id);

                            if (encontrado != null) {
                                System.out.println(encontrado);
                            } else {
                                System.out.println("Livro não encontrado!");
                            }
                            break;

                        case 4:
                            System.out.print("ID para remover: ");
                            int idRemover = sc.nextInt();

                            livroController.remover(idRemover);
                            System.out.println("Livro removido!");
                            break;

                        case 0:
                            System.out.println("Saindo...");
                            break;

                        default:
                            System.out.println("Opção inválida!");
                    } 

                    } while (opcao != 0);
                    
                
                sc.close();
             
        }
    }

