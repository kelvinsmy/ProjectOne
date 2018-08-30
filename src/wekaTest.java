import weka.associations.Apriori;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class wekaTest {
    public static void main (String[] args) throws Exception{

        String dataset = "./markSix.arff";
        DataSource source = new DataSource(dataset);
        Instances data = source.getDataSet();

        Apriori model = new Apriori();
        model.setLowerBoundMinSupport(0.0001);
        model.buildAssociations(data);
        System.out.println(model);

        //clustering
        /*
        SimpleKMeans model = new SimpleKMeans();//Simple EM (expectation maximisation)
        //number of clusters
        model.setNumClusters(4);
        //set distance function
        //model.setDistanceFunction(new weka.core.ManhattanDistance());
        // build the clusterer
        model.buildClusterer(data);
        System.out.println(model);

        //to cluster an instance .. returns cluster number as int
        //model.clusterInstance(instance);

        //returns an array containing the estimated membership probabilities of the test instance in each cluster (this should sum to at most 1)
        //model.distributionForInstance(instance);

        ClusterEvaluation clsEval = new ClusterEvaluation();
        //load dataset
        String dataset1 = "/home/likewise-open/ACADEMIC/csstnns/Desktop/weather.test.arff";
        DataSource source1 = new DataSource(dataset1);
        //get instances object
        Instances data1 = source1.getDataSet();

        clsEval.setClusterer(model);
        clsEval.evaluateClusterer(data1);//this should be a test dataset!

        System.out.println("# of clusters: " + clsEval.getNumClusters());
        */
    }
}
