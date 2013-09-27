library(ggplot2)

sorting.results <- read.table("sorting-results.csv", header=T, sep=",")

plot.sorting <- qplot (sorting.results$n, sorting.results$duration, data=sorting.results,
                        colour = as.factor(sorting.results$algorithm),
                        group = sorting.results$algorithm,
                        geom = "path",
                        main = "Linear Time Sorting Algorithm Benchmark",
                        xlab = "Number of Elements",
                        ylab = " Total Time (nanoseconds)",
                        ylim = c(0,400000),
                        xlim = c(0, 10000))
# Print plot
print (plot.sorting)