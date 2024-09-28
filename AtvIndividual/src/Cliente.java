import java.util.List;
import java.util.Random;

class Cliente extends Thread {
    private String nome;
    private Conta conta;
    private List<Loja> lojas;
    private Banco banco;
    private Random random;

    public Cliente(String nome, Conta conta, List<Loja> lojas, Banco banco) {
        this.nome = nome;
        this.conta = conta;
        this.lojas = lojas;
        this.banco = banco;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (Loja loja : lojas) {
            for (int i = 0; i < 2; i++) {
                double valorCompra = 200 + random.nextDouble() * 300;
                System.out.println(nome + " está comprando na " + loja.getNome() + " por R$ " + valorCompra);
                banco.transferir(conta, loja.getConta(), valorCompra);
            }
        }
    }

    // Método para obter o nome do cliente
    public String getNome() {
        return nome;
    }

    // Método para obter a conta do cliente
    public Conta getConta() {
        return conta;
    }
}
