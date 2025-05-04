package farmaciaVirtual.model;

public class Cosmetico extends Produto {
    private String fragrancia;
    
    public Cosmetico(String nome, int id, float preco, String fragrancia) {
        super(nome, id, preco);
        this.fragrancia = fragrancia; 
    }
    
    public String getFragrancia() {
        return fragrancia;
    }
    
    public void setFragrancia(String fragrancia) {
        this.fragrancia = fragrancia;
    }

    @Override
    public void visualizar() {
        super.visualizar(); // Chama o método da classe Produto
        System.out.println("Fragrância: " + fragrancia); // Mostra a fragrância do cosmético
    }
}

