# Analyzer
the Algorithm for Cluster analysis based on Weber–Fechner law. Weber's law states that the just-noticeable difference between two stimuli is proportional to the magnitude of the stimuli.
At first, the Algorithm finds a pair in a sorted array that has minimum value among them. The pair treated as a cluster, and then Algorithm searches nearest neighbours that have distance (< minimum*2). Such neighbours are ranked as the cluster members. When all neighbours have been found, Algorithm starts to explore other clusters.
@Pavel Karnaukhov
