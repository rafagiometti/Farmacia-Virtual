package farmaciaVirtual;

import java.util.ArrayList;
import java.util.Scanner;
import farmaciaVirtual.model.Cosmetico;
import farmaciaVirtual.model.Medicamento;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		int resposta = 1;
		
		// Criando ArrayLists para armazenar os produtos
        ArrayList<Medicamento> listaMedicamentos = new ArrayList<>();
        ArrayList<Cosmetico> listaCosmeticos = new ArrayList<>();
		
		while(resposta != 0) {
			
			System.out.println("========== Menu Principal ======");
			System.out.println("1 - Cadastrar Medicamento");
			System.out.println("2 - Cadastrar Cosmético");
			System.out.println("3 - Listar todos os produtos");
			System.out.println("4 - Consultar produto por ID");
			System.out.println("5 - Atualizar produto");
			System.out.println("6 - Deletar produto");
			System.out.println("0 - Sair");
			System.out.println("=================================");
			resposta = leia.nextInt();	
			leia.nextLine();  // Limpando o buffer
			
			switch(resposta) {
				case 1:
					// Cadastrar Medicamento
					System.out.println("Digite o nome do medicamento:");
					String nomeMedicamento = leia.nextLine();
					System.out.println("Digite o ID do medicamento:");
					int idMedicamento = leia.nextInt();
					System.out.println("Digite o valor do medicamento:");
					float precoMedicamento = leia.nextFloat();
					leia.nextLine();  // Limpando o buffer
					System.out.println("É genérico (sim ou não)?");
					String generico = leia.nextLine();
					
					// Criando o objeto Medicamento e adicionando na lista
					Medicamento medicamento = new Medicamento(nomeMedicamento, idMedicamento, precoMedicamento, generico);
					listaMedicamentos.add(medicamento);
					System.out.println("Medicamento cadastrado com sucesso!");
					break;
					
				case 2:
					// Cadastrando Cosmético
					System.out.println("Digite o nome do cosmético:");
					String nomeCosmetico = leia.nextLine();
					System.out.println("Digite o ID do cosmético:");
					int idCosmetico = leia.nextInt();
					System.out.println("Digite o valor do cosmético:");
					float precoCosmetico = leia.nextFloat();
					leia.nextLine();  // Limpar o buffer
					System.out.println("Digite a fragrância:");
					String fragrancia = leia.nextLine();
					
					// Criando o objeto Cosmético e adicionando na lista
					Cosmetico cosmetico = new Cosmetico(nomeCosmetico, idCosmetico, precoCosmetico, fragrancia);
					listaCosmeticos.add(cosmetico);
					System.out.println("Cosmético cadastrado com sucesso!");
					break;
					
				case 3:
					// Listando todos os produtos
					System.out.println("Listando todos os produtos:");
                    System.out.println("=== Cosméticos ===");
                    for (Cosmetico c : listaCosmeticos) {
                        c.visualizar();
                    }
                    System.out.println("=== Medicamentos ===");
                    for (Medicamento m : listaMedicamentos) {
                        m.visualizar();
                    }
                    break;
                    
				case 4:
				    // Consultando Produto por ID
				    System.out.println("Digite o ID do produto para consulta:");
				    int idConsulta = leia.nextInt();
				    leia.nextLine();  

				    // Consultando em Medicamentos
				    boolean produtoEncontrado = false;
				    for (Medicamento m : listaMedicamentos) {
				        if (m.getId() == idConsulta) {
				            m.visualizar();  // Exibe as informações do Medicamento
				            produtoEncontrado = true;
				            break;
				        }
				    }

				    // Consultando em Cosméticos, caso não tenha encontrado no Medicamento
				    if (!produtoEncontrado) {
				        for (Cosmetico c : listaCosmeticos) {
				            if (c.getId() == idConsulta) {
				                c.visualizar();  // Exibe as informações do Cosmético
				                produtoEncontrado = true;
				                break;
				            }
				        }
				    }

				    // Caso o produto não seja encontrado
				    if (!produtoEncontrado) {
				        System.out.println("Produto não encontrado!");
				    }
				    break;
				case 5:
				    // Atualizar Produto
				    System.out.println("Digite o ID do produto para atualizar:");
				    int idAtualizar = leia.nextInt();
				    leia.nextLine();  // Limpar o buffer

				    // Buscar no Medicamento
				    boolean produtoAtualizado = false;
				    for (int i = 0; i < listaMedicamentos.size(); i++) {
				        if (listaMedicamentos.get(i).getId() == idAtualizar) {
				            // Produto encontrado, agora pedir novos dados
				            System.out.println("Digite o novo nome do medicamento:");
				            String novoNomeMedicamento = leia.nextLine();
				            System.out.println("Digite o novo preço do medicamento:");
				            float novoPrecoMedicamento = leia.nextFloat();
				            leia.nextLine();  // Limpar o buffer

				            // Atualizando os dados
				            Medicamento m = listaMedicamentos.get(i);
				            m.setNome(novoNomeMedicamento);
				            m.setPreco(novoPrecoMedicamento);

				            System.out.println("Produto atualizado com sucesso!");
				            produtoAtualizado = true;
				            break;
				        }
				    }

				    // Buscar no Cosmético, caso não tenha encontrado no Medicamento
				    if (!produtoAtualizado) {
				        for (int i = 0; i < listaCosmeticos.size(); i++) {
				            if (listaCosmeticos.get(i).getId() == idAtualizar) {
				                // Produto encontrado, agora pedir novos dados
				                System.out.println("Digite o novo nome do cosmético:");
				                String novoNomeCosmetico = leia.nextLine();
				                System.out.println("Digite o novo preço do cosmético:");
				                float novoPrecoCosmetico = leia.nextFloat();
				                leia.nextLine();  // Limpar o buffer

				                // Atualizando os dados
				                Cosmetico c = listaCosmeticos.get(i);
				                c.setNome(novoNomeCosmetico);
				                c.setPreco(novoPrecoCosmetico);

				                System.out.println("Produto atualizado com sucesso!");
				                produtoAtualizado = true;
				                break;
				            }
				        }
				    }

				    // Se o produto não foi encontrado
				    if (!produtoAtualizado) {
				        System.out.println("Produto não encontrado!");
				    }
				    break;
				case 6:
				    // Deletar Produto
				    System.out.println("Digite o ID do produto para deletar:");
				    int idDeletar = leia.nextInt();
				    leia.nextLine();  // Limpar o buffer

				    // Buscar e deletar no Medicamento
				    boolean produtoDeletado = false;
				    for (int i = 0; i < listaMedicamentos.size(); i++) {
				        if (listaMedicamentos.get(i).getId() == idDeletar) {
				            listaMedicamentos.remove(i);  // Deletar o produto
				            System.out.println("Produto deletado com sucesso!");
				            produtoDeletado = true;
				            break;
				        }
				    }

				    // Buscar e deletar no Cosmético, caso não tenha encontrado no Medicamento
				    if (!produtoDeletado) {
				        for (int i = 0; i < listaCosmeticos.size(); i++) {
				            if (listaCosmeticos.get(i).getId() == idDeletar) {
				                listaCosmeticos.remove(i);  // Deletar o produto
				                System.out.println("Produto deletado com sucesso!");
				                produtoDeletado = true;
				                break;
				            }
				        }
				    }

				    // Se o produto não foi encontrado
				    if (!produtoDeletado) {
				        System.out.println("Produto não encontrado!");
				    }
				    break;	
				case 0:
					System.out.println("Saindo do sistema...");
					break;
					
				default:
					System.out.println("Opção inválida!");
					break;
			}
		}
		
		leia.close();
	}
}
