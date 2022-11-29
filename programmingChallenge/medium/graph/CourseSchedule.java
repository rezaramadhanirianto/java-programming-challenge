package programmingChallenge.medium.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule
public class CourseSchedule {
    // DFS Without Dynamic programming
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) graph[i] = new ArrayList();
        for(int i = 0; i < prerequisites.length; i++) graph[prerequisites[i][1]].add(prerequisites[i][0]);

        for(int i = 0; i < numCourses; i++){
            if(!dfs(graph, visited, i)) return false;
        }
        return true;
    }

    // if we found same number in the same dfs that means we found cycle
    boolean dfs(ArrayList<Integer>[] graph, boolean[] visited, int course){
        if(visited[course]) return false;
        visited[course] = true;
        for(int i = 0; i < graph[course].size(); i++){
            if(!dfs(graph, visited, graph[course].get(i))) return false;
        }
        visited[course] = false;
        return true;
    }

    // DFS with dynamic programming
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        boolean[] dp = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) graph[i] = new ArrayList();
        for(int i = 0; i < prerequisites.length; i++) graph[prerequisites[i][1]].add(prerequisites[i][0]);

        for(int i = 0; i < numCourses; i++){
            if(!dfs(graph, visited, i, dp)) return false;
        }
        return true;
    }

    boolean dfs(ArrayList<Integer>[] graph, boolean[] visited, int course, boolean[] dp){
        if(visited[course]) return dp[course];
        visited[course] = true;
        for(int i = 0; i < graph[course].size(); i++){
            if(!dfs(graph, visited, graph[course].get(i), dp)){
                dp[course] = false;
                return false;
            }
        }
        dp[course] = true;
        return true;
    }

    // bfs topological sort
    public boolean canFinish3(int numCourses, int[][] prerequisites){
        int[] requirement = new int[numCourses];
        List<Integer>[] graph = new List[numCourses];
        Queue<Integer> queue = new LinkedList();
        int size = prerequisites.length;

        for(int i=0; i < numCourses; i++) graph[i] = new LinkedList<Integer>();
        for(int[] pair: prerequisites){
            requirement[pair[0]]++;
            graph[pair[1]].add(pair[0]);
        }

        for(int i = 0; i < numCourses; i++){
            if(requirement[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int course = (int) queue.poll();
            for(int c: graph[course]){
                size--;
                if(--requirement[c] == 0) queue.add(c);
            }
        }

        return size == 0;
    }
}
