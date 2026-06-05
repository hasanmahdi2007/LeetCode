class Twitter {
    int time;
    Map<Integer, ArrayDeque<int[]>> tweets;
    Map<Integer, HashSet<Integer>> followings;
    public Twitter() {
        tweets = new HashMap<>();
        followings = new HashMap<>();

    }

    private void UserCreate(int userId) {
        if (!followings.containsKey(userId)) {
            HashSet<Integer> s = new HashSet<>();
            s.add(userId);
            followings.put(userId, s);
        }
        tweets.putIfAbsent(userId, new ArrayDeque<>());
    }
    
    public void postTweet(int userId, int tweetId) {
        UserCreate(userId);
        if(tweets.containsKey(userId)){
            ArrayDeque<int[]> s = tweets.get(userId);
            s.push(new int[] {tweetId, time++});
        }
        else{
            ArrayDeque<int[]> s = new ArrayDeque<>();
            s.push(new int[] {tweetId, time++});
            tweets.put(userId, s);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        UserCreate(userId);
        List<Integer> array = new ArrayList<>();
        Map<Integer, ArrayDeque<int[]>> restoredMap = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));
        for(int following : followings.get(userId)){
            ArrayDeque<int[]> s = tweets.get(following);
            if(s != null && !s.isEmpty()) {
                int[] a = s.pop();
                restoredMap.putIfAbsent(following, new ArrayDeque<>());
                restoredMap.get(following).push(a);
                heap.offer(new int[] {a[1], a[0],  following});
            }    
        }
        while (!heap.isEmpty() && array.size() < 10){
            int[] element = heap.poll();
            array.add(element[1]);
            ArrayDeque<int[]> s = tweets.get(element[2]);
            if(s != null && !s.isEmpty()){
                int[] newElement = s.pop();
                restoredMap.putIfAbsent(element[2], new ArrayDeque<>());
                restoredMap.get(element[2]).push(newElement);
                heap.add(new int[] {newElement[1], newElement[0], element[2]});
            }    
        }
        for (int authorId : restoredMap.keySet()) {
            ArrayDeque<int[]> tempStack = restoredMap.get(authorId);
            ArrayDeque<int[]> originalStack = tweets.get(authorId);
            while (!tempStack.isEmpty()) {
                originalStack.push(tempStack.pop());
            }
        }
        return array;
    }
    
    public void follow(int followerId, int followeeId) {
        UserCreate(followerId);
        followings.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        UserCreate(followerId);
        followings.get(followerId).remove(followeeId);
    }
}

/* ===========================================================================
  💡 SYSTEM DESIGN CHECKLIST: RECENT FEED SELECTION (K-WAY MERGE VIA STACKS)
  ===========================================================================
  
  1. TRACK GLOBAL CHRONOLOGICAL TIME (Recency Calculation)
     - Raw tweet IDs (e.g., 5, 13, 104) are completely random and do not indicate order.
     - MISSING NEXT TIME: You need a global `int timestamp = 0;` field that increments 
       every time ANY user posts a tweet. Store the tweet as a pair: `new int[]{timestamp, tweetId}`.
  
  2. HEAP TYPE MATCHING & SIGNATURE
     - Your initialization: `PriorityQueue<Integer> heap = new PriorityQueue<>(...)` 
       but you were trying to push an array `new int[]` into it. 
     - MISSING NEXT TIME: Match the generic type declaration with what you are pushing.
       It must be: `PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);`
  
  3. KEEP TRACK OF DATA AUTHORSHIP IN THE HEAP
     - Inside the heap loop, you tried to find the next element using: `tweets.get(element[1])`
       where element[1] was your loop index, not the person who posted the tweet.
     - MISSING NEXT TIME: The heap array needs to hold an origin pointer. 
       Store it as: `new int[]{ timestamp, tweetId, authorId }`.
       This tells the heap EXACTLY whose stack needs to be popped next: `tweets.get(element[2]).pop()`.
  
  4. THE DESTRUCTIVE NATURE OF POPPING (The Restoration Step)
     - When you use `.pop()` on a user's original stack inside `getNewsFeed`, you are 
       permanently erasing their history from the database for future API calls.
     - MISSING NEXT TIME: Use a temporary data structure `Map<Integer, ArrayDeque<int[]>> restoredMap` 
       to cache every single element you pop out. Before returning the final list, 
       run a loop to `.push()` them all back onto the original user stacks.
  
  5. IMPLICIT SELF-FOLLOWING & DEFENSIVE INITIALIZATION
     - LeetCode will trigger `follow` or `getNewsFeed` actions for users before they 
       have ever posted a tweet, which causes immediate `NullPointerException`s on uninitialized maps.
     - MISSING NEXT TIME: Create an `initUser(userId)` helper method. Always ensure that 
       when a user is created, they automatically follow themselves: `followings.get(userId).add(userId);` 
       otherwise their own tweets will never appear in their personal news feed!
*/

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */