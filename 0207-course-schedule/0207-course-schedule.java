class Solution {
    private class Node {
        ArrayList<Node> pres;
        boolean visited;
        boolean solvable;
        public Node(){
            pres = new ArrayList<>();
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] courses = new Node[numCourses];
        for(int i = 0; i < numCourses; i++){
            courses[i] = new Node();
        }
        for(int i = 0; i < prerequisites.length; i++){
            int[] pre = prerequisites[i];
            courses[pre[0]].pres.add(courses[pre[1]]);
        }
        boolean[] solvable = new boolean[numCourses];
        for(Node course : courses){
            if(!solvableChecker(course)) return false;
        }
        return true;
    }

    public boolean solvableChecker(Node course){
        if(course.pres.size() == 0) course.solvable = true;
        if(course.solvable) return true;
        if(course.visited) return false;
        course.visited = true;
        for(Node pre: course.pres){
            if(!solvableChecker(pre)) return false;
        }
        course.solvable = true;
        return true;
    }
}