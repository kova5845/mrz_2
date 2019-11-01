public class NeuralNetwork {
    Neuron[][] neuron;
    int[] layer;
    int layerKol;

    public NeuralNetwork(int[] layer, int layerKol) {
        this.layer = layer;
        this.layerKol = layerKol;
        neuron = new Neuron[layerKol][];
        for (int i = 0; i < layerKol; i++) {
            neuron[i] = new Neuron[layer[i]];
        }
        for (int i = 0; i < layer[0]; i++) {
            neuron[0][i] = new Neuron(1, layer[1]);
        }
        for (int i = 1; i < layerKol - 1; i++) {
            for (int j = 0; j < layer[i]; j++) {
                neuron[i][j] = new Neuron(layer[i - 1], layer[i + 1]);
            }
        }
        for (int i = 0; i < layer.length; i++) {
            neuron[layer.length][i] = new Neuron(layer[layer.length - 1], 1);
        }
    }
}
