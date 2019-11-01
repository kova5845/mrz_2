import java.util.Vector;

public class Neuron {
    double[] weight;
    int inputKol, outputKol;
    Vector<Integer> inputVector;
    double input, output;

    public Neuron(int inputKol, int outputKol) {
        this.inputKol = inputKol;
        this.outputKol = outputKol;
        weight = new double[inputKol];
        for (int i = 0; i < inputKol; i++) {
            weight[i] = Math.random() * 1.5 - 0.7;
        }
        inputVector = new Vector<>();
        output = 0;
        input = 0;
    }

    public void setData(int in) {
        inputVector.add(in);
        if (inputVector.size() == inputKol) {
            input = 0;
            for (int i = 0; i < inputKol; i++) {
                input += inputVector.get(i) * weight[i];
            }
        }
        output = (Math.exp(input) - Math.exp(-input)) / (Math.exp(input) + Math.exp(-input));
    }

    public double getData() {
        if (output > 0)
            return 1;
        else return 0;
    }
}
