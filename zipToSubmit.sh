if [ -e percolation.zip ] 
then
    rm percolation.zip
fi

zip percolation.zip src/week1/Percolation.java src/week1/PercolationStats.java

