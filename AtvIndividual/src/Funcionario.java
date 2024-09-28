class Funcionario extends Thread {
    private String nome;
    private Conta contaSalario;
    private Conta contaInvestimento;
    private double salario;

    public Funcionario(String nome, double salario, Conta contaSalario, Conta contaInvestimento) {
        this.nome = nome;
        this.salario = salario;
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
    }

    public void receberSalario() {
        System.out.println(nome + " vai receber o salário de R$ " + salario);
        contaSalario.depositar(salario);  // O funcionário recebe o salário na conta de salário
        double investimento = salario * 0.2;  // Calcula o valor a ser investido
        contaSalario.sacar(investimento);  // Deduz o valor de investimento da conta de salário
        contaInvestimento.depositar(investimento);  // Deposita o investimento na conta de investimento
        System.out.println(nome + " investiu R$ " + investimento + " na conta de investimento.");
    }

    @Override
    public void run() {
        receberSalario();
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getContaInvestimento() {
        return contaInvestimento;
    }

    public String getNome() {
        return nome;
    }
}
