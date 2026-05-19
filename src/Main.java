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
            System.out.println("4 - Editar cliente");
            System.out.println("5 - Excluir Cliente");
            System.out.println("6 - Cadastrar veículo");
            System.out.println("7 - Listar veículos");
            System.out.println("8 - Editar veículo");
            System.out.println("9 - Excluir veículo");
            System.out.println("10 - Sair");

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
                    System.out.println("Digite o ID que deseja editar: ");
                    int idEditar = sc.nextInt();

                    boolean clienteEncontrado = false;

                    for (int i = 0; i < clientes.size(); i++) {
                        Cliente ce = clientes.get(i);

                        if(ce.id == idEditar) {
                            clienteEncontrado = true;

                            System.out.println("Cliente encontrado! ");
                            System.out.println(" ID: " + ce.id +
                                               " | Nome: " + ce.nome +
                                               " | Celular: " + ce.celular
                            );

                            System.out.println("Esse é o ID que deseja editar? " +
                                               " ID: " + ce.id +
                                               " | Nome: " + ce.nome +
                                               " | Celular: " + ce.celular +
                                               " | Digite s/n: "
                            );
                            sc.nextLine();
                            String resposta = sc.nextLine();

                            if (resposta.equalsIgnoreCase("s")) {

                                System.out.println("Novo nome: ");
                                ce.nome = sc.nextLine();

                                System.out.println("Novo celular:");
                                ce.celular = sc.nextLine();

                                System.out.println("Cliente editado com sucesso! ");
                            }

                        }
                    }
                if (!clienteEncontrado) {
                    System.out.println("Cliente não encontrado. ");

                }
                    break;

                case 5:
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

                case 6:
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

                    System.out.println("Digite o ID do dono do veículo: ");
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

                case 7:
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

                case 8:
                    System.out.println("Digite o ID do carro que deseja editar: ");
                    int veiculoId = sc.nextInt();

                    boolean veiculoEncontrado = false;

                    for ( int i = 0; i < veiculos.size(); i++) {
                        Veiculo ve = veiculos.get(i);

                        if (ve.id == veiculoId) {
                            veiculoEncontrado = true;

                            System.out.println("Veiculo encontrado! ");
                            System.out.println("ID: " + ve.id +
                                               " | Modelo: " + ve.modelo +
                                               " | Marca: " + ve.marca +
                                               " | Placa: " + ve.placa +
                                               " | Ano: " + ve.ano
                            );

                            System.out.println("Esse é o veículo que deseja editar? " +
                                              "ID: " + ve.id +
                                              " | Modelo: " + ve.modelo +
                                              " | Marca: " + ve.marca +
                                              " | Placa: " + ve.placa +
                                              " | Ano: " + ve.ano +
                                              " | Digite s/n: "
                            );
                            sc.nextLine();
                            String resposta = sc.nextLine();

                            if (resposta.equalsIgnoreCase("s")) {

                                System.out.println("Novo modelo: ");
                                ve.modelo = sc.nextLine();

                                System.out.println("Nova marca: ");
                                ve.marca = sc.nextLine();

                                System.out.println("Nova placa: ");
                                ve.placa = sc.nextLine();

                                System.out.println("Novo ano: ");
                                ve.ano = sc.nextInt();
                                sc.nextLine();

                                System.out.println("Veículo editado com sucesso! ");
                            }
                        }
                    }

                if (!veiculoEncontrado) {

                    System.out.println("Veiculo não encontrado! ");
                }
                    break;

                case 10:
                    System.out.println("Saindo do programa! ");
                    sc.close();
                    return;

                        default:
                            System.out.println("Opção inválida! ");
                    }

            }


        }
    }
