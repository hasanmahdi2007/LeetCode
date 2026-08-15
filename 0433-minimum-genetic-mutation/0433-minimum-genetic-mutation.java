class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        boolean[] visited = new boolean[bank.length];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(-1);
        int mutations = 0;
        while(!q.isEmpty()){
            int steps = q.size();
            for(int i = 0; i < steps; i++){
                int index = q.poll();
                String current = (index == -1) ? startGene:bank[index];
                if(current.equals(endGene)) return mutations;
                for(int j = 0; j < bank.length; j++){
                    if(visited[j]) continue;
                    int diffs = 0;
                    boolean valid = true;
                    String gene = bank[j];
                    for(int k = 0; k < 8; k++){
                        if(current.charAt(k) != gene.charAt(k)) diffs++;
                        if(diffs > 1) {
                            valid = false;
                            break;
                        }
                    }
                    if(valid) {
                        q.offer(j);
                        visited[j] = true;
                    }
                }
            }
            mutations++;
        }
        return -1;
    }
}