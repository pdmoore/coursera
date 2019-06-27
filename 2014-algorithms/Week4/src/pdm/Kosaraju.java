package pdm;

 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.zip.ZipFile;

import pdm.DirectedGraph.EdgeTraversalPolicy;
 

public class Kosaraju {
    
    private static int t;
    private static long edgeCount;
    private static ArrayList<Integer> scc = new ArrayList<Integer>();
    private static int pass = 0;
    
    private static void dfsLoop(DirectedGraph gr, DirectedGraph.EdgeTraversalPolicy tp ) {
        t = 0;
        
        Collection<DirectedVertex> vs; 
        if( pass == 0 ) 
            vs = gr.getVerticesInReversedOrder().values();
        else {
            vs = new TreeSet<DirectedVertex>(new Comparator<DirectedVertex>() {
                @Override
                public int compare( DirectedVertex v1, DirectedVertex v2 ) {
                    return new Integer( v2.getF() ).compareTo( v1.getF() );
                }
            });
            vs.addAll( gr.getVertices().values() );
        }
        
        for ( DirectedVertex v : vs ) {
            if( !v.isVisited() ) {
                
                dfs( tp, v );
                
                if( pass == 1 ) {
                    scc.add( t );
                    t = 0;
                }
            }
        }
        
        pass++;
    }
    
    private static void dfs( EdgeTraversalPolicy tp, DirectedVertex v ) {
        
        v.setVisited( true );
        
        for ( DirectedEdge edge : tp.edges( v ) ) {
            DirectedVertex next = tp.vertex( edge );
            if( !next.isVisited() )
                dfs( tp, next );
        }
        t++;
        if( pass == 0 ) {
            v.setF( t );
        }
    }
    
    private static DirectedGraph readGraph( InputStream is ) throws FileNotFoundException {
        Scanner sc = new Scanner( is );
        DirectedGraph gr = new DirectedGraph();
        while( sc.hasNext() ) {
            addEdge( gr, sc.nextInt(), sc.nextInt() );
        }
        sc.close();
        System.out.println("fourth");   	
               
        return gr;
    }
    
    
    private static DirectedGraph readGraph(BufferedReader in) throws IOException {
        DirectedGraph gr = new DirectedGraph();
        String x = in.readLine();
        while (x != null) {
        	String[] tokens = x.split(" ");
            addEdge( gr, Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]) );
            x = in.readLine();
            if (edgeCount % 10000 == 0) {
            	System.out.println(edgeCount);
            }
        }
        System.out.println("fourth");   	
               
        return gr;
	}

    
    private static void addEdge( DirectedGraph gr, int tailId, int headId ) {
    	edgeCount++;
        DirectedVertex tail = gr.getVertex( tailId );
        DirectedVertex head = gr.getVertex( headId );
        DirectedEdge edge = new DirectedEdge( tail, head );
        gr.addEdge( edge );
        tail.addOutgoingEdge( edge );
        head.addIncomingEdge( edge );
    }
 
    private static void test( DirectedGraph gr ) {
        System.out.println("First pass:");
        
        dfsLoop( gr, DirectedGraph.BACKWARD_TRAVERSAL );
        
        gr.reset();
        System.out.println("Second pass:");
        dfsLoop( gr, DirectedGraph.FORWARD_TRAVERSAL );
        
        int count = 0;
        Collections.sort( scc );
        for( int i = scc.size()-1; i >= 0; i-- ) {
            if( count >= 5 ) break;
            System.out.println("ssc:" + scc.get( i ));
            count++;
        }
        
        cleanup();
    }
 
    private static void cleanup() {
        t = 0;
        pass = 0;
        edgeCount = 0;
        scc.clear();
    }
    
    private static DirectedGraph example1() {
        DirectedGraph gr = new DirectedGraph();
        addEdge( gr, 1, 2 );
        addEdge( gr, 1, 3 );
        addEdge( gr, 3, 4 );
        addEdge( gr, 2, 4 );
        return gr;
    }
 
    private static DirectedGraph example2() {
        DirectedGraph gr = new DirectedGraph();
        addEdge( gr, 1, 4 );
        addEdge( gr, 2, 8 );
        addEdge( gr, 3, 6 );
        addEdge( gr, 4, 7 );
        addEdge( gr, 5, 2 );
        addEdge( gr, 6, 9 );
        addEdge( gr, 7, 1 );
        addEdge( gr, 8, 5 );
        addEdge( gr, 8, 6 );
        addEdge( gr, 9, 3 );
        addEdge( gr, 9, 7 );
        return gr;
    }
    
    private static DirectedGraph example1a() {
        DirectedGraph gr = new DirectedGraph();
        addEdge( gr, 1, 2 );
        addEdge( gr, 1, 3 );
        addEdge( gr, 1, 4 );
        addEdge( gr, 2, 3 );
        addEdge( gr, 2, 4 );
        addEdge( gr, 3, 4 );
        return gr;
    }

    private static DirectedGraph example1b() {
        DirectedGraph gr = new DirectedGraph();
        addEdge( gr, 7, 1 );
        addEdge( gr, 1, 4 );
        addEdge( gr, 4, 7 );
        addEdge( gr, 9, 7 );
        addEdge( gr, 6, 9 );
        addEdge( gr, 9, 3 );
        addEdge( gr, 3, 6 );
        addEdge( gr, 8, 6 );
        addEdge( gr, 2, 8 );
        addEdge( gr, 5, 2 );
        addEdge( gr, 8, 5 );
        addEdge( gr, 3, 10 );
        addEdge( gr, 10, 11 );
        addEdge( gr, 10, 12 );
        addEdge( gr, 11, 10 );
        addEdge( gr, 12, 3 );
        
        
        
        return gr;
    }
    
//    private static DirectedGraph example3()
//            throws Exception {
//        
//        long start = System.currentTimeMillis();
//        ZipFile zf = new ZipFile( "src/org/coursera/algo/SCC.zip" );
//        DirectedGraph g = readGraph( zf.getInputStream( zf.getEntry( "SCC.txt" ) ) );
//        
//        System.out.println( "Read from ZIP: " + ( System.currentTimeMillis() - start ) );
//        System.out.println( "Graph: " + g.getVertices().size() + " vertices, "
//                + g.getEdges().size() + " edges." );
//        return g;
//    }
    
    private static DirectedGraph example3b()
            throws Exception {
        
 System.out.println("starting file read");   	
        long start = System.currentTimeMillis();
        
        BufferedReader in = new BufferedReader(new FileReader(new File("SCC.txt")));
        DirectedGraph g = readGraph(in);
        

 System.out.println("finished read");     
        System.out.println( "Read from file: " + ( System.currentTimeMillis() - start ) );
        System.out.println( "Graph: " + g.getVertices().size() + " vertices, "
                + g.getEdges().size() + " edges." );
        return g;
    }


// This one was dependent on getting the VM settings right - see Run Configurations
    //-Xmx2048m -Xms1024m -Xmn256m -Xss16m
    // The Xmx value of 2048 was key - otherwise was timing out/running out of memory
    public static void main( String[] args ) throws Exception {
        
//    	test(example3());
         test(example3b());			// correct answer is 434821,968,459,313,211
//         test(example2());
//         test(example3());
    }
 
}