import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int contadorId = 1;
        int contadorVeiculoId = 1;


        while (true) {

            System.out.println("______________Menu______________");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Buscar Cliente");
            System.out.println("4 - Excluir Cliente");
            System.out.println("5 - Cadastrar veículo");
            System.out.println("6 - Listar veículos");
            System.out.println("7 - Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    Cliente novoCliente = new Cliente();

                    novoCliente.id = contadorId;
                    contadorId++;

                    System.out.println("Nome: ");
                    novoCliente.nome = sc.nextLine();

                    System.out.println("Celular: ");
                    novoCliente.celular = sc.nextLine();

                    clientes.add(novoCliente);

                    System.out.println("Cliente cadastrado! ");
                    System.out.println();
                    break;

                case 2:
                    if (clientes.size() == 0) {
                        System.out.println("Nenhum cliente cadastrado. ");
                    } else {
                        for (int i = 0; i < clientes.size(); i++) {
                            Cliente c = clientes.get(i);
                            System.out.println(
                                    "ID " + c.id +
                                            " | Nome: " + c.nome +
                                            " | Celular: " + c.celular
                            );
                            System.out.println("------------------------------------------");

                        }
                    }
                    break;

                case 3:
                    System.out.println("Digite o ID do cliente!");
                    int id = sc.nextInt();

                    boolean encontrado = false;

                    for (int i = 0; i < clientes.size(); i++) {
                        Cliente c = clientes.get(i);

                        if (c.id == id) {
                            System.out.println("Cliente encontrado! ");
                            System.out.println(
                                    " ID: " + c.id +
                                            " | Nome: " + c.nome +
                                            " | Celular: " + c.celular
                            );

                            encontrado = true;
                            break;

                        }
                    }
                    if (!encontrado) {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Digite o ID que deseja excluir: ");
                    id = sc.nextInt();

                    boolean removido = false;

                    for (int i = 0; i < clientes.size(); i++) {
                        Cliente c = clientes.get(i);

                        if (c.id == id) {
                            System.out.println("ID encontrado: ");
                            System.out.println("Esse é o ID que deseja excluir? "  +
                                    "ID: " + c.id  +
                                    " | " + c.nome +
                                    " | Digite s/n: "
                            );
                            sc.nextLine();
                            String resposta = sc.nextLine();

                            if (resposta.equalsIgnoreCase("s")) {
                                clientes.remove(i);
                                removido = true;

                                System.out.println("CLliente removido com sucesso! ");

                                break;
                            }
                        }
                    }
                    if (!removido) {
                        System.out.println("Cliente não encontrado. ");
                    }
                    break;

                case 5:
                    Veiculo novoVeiculo = new Veiculo();

                    novoVeiculo.id = contadorVeiculoId;
                    contadorVeiculoId++;

                    System.out.println("Modelo: ");
                    novoVeiculo.modelo = sc.nextLine();

                    System.out.println("Marca: ");
                    novoVeiculo.marca = sc.nextLine();

                    System.out.println("Placa: ");
                    novoVeiculo.placa = sc.nextLine();

                    System.out.println("Ano: ");
                    novoVeiculo.ano = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite o ID do done do veículo: ");
                    int IdDono = sc.nextInt();
                    sc.nextLine();

                    boolean donoEncontrado = false;

                    for (int i =0; i < clientes.size(); i++) {
                        Cliente c = clientes.get(i);

                        if (c.id == IdDono) {
                            novoVeiculo.dono = c;
                            donoEncontrado = true;
                        }
                    }

                    if (donoEncontrado) {
                        veiculos.add(novoVeiculo);
                        System.out.println("Veículo cadastrado! ");
                    } else {
                        System.out.println("Cliente não encontrado");
                    }
                    break;

                case 6:
                    if (veiculos.size() == 0) {
                        System.out.println("Nenhum veículo cadastrado. ");
                    } else {
                        for (int i = 0; i < veiculos.size(); i++) {
                            Veiculo v = veiculos.get(i);
                            System.out.println("ID " + v.id +
                                    " | Dono: " + v.dono.nome +
                                    " | Modelo: " + v.modelo +
                                    " | Marca: " + v.marca +
                                    " | Placa: " + v.placa +
                                    " | Ano: " + v.ano
                            );
                            System.out.println("---------------------------------------------------------------------------------");
                        }
                    }
                    break;

                case 7:
                    System.out.println("Saindo do programa! ");
                    sc.close();
                    return;

                        default:
                            System.out.println("Opção inválida! ");
                    }

            }


        }
    }
