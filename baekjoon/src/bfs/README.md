## 1. 바이러스(Virus.java)

이 문제는 dfs를 이용해서 풀 수도 있지만 제일 가까이 연결된 컴퓨터부터 바이러스가 걸리기 때문에 bfs로 구현했다.

구현 순서는
1) 연결된 컴퓨터 쌍을 저장
2) 컴퓨터1을 큐에 넣고 거기에 연결된 컴퓨터들을 계속 큐에 넣으면서 방문했는지 체크
3) 처음 방문한 컴퓨터는 count변수로 세기

이 순서로 구현했다.
1번은 HashMap을 이용해 key를 컴퓨터 번호, value를 그 컴퓨터에 연결된 컴퓨터 번호 list로 구현했다.

2, 3번은 bfs 메소드 안에서 while문으로 queue가 빌 때까지 계속 돌면서 방문한 컴퓨터를 체크하고 처음 방문했으면 count변수에 1씩 더했다.
방문 체크는 boolean 배열을 이용했다.
```
static void bfs(HashMap<Integer, ArrayList<Integer>> hm, boolean[] visited) {
  while(!queue.isEmpty()) {
    int num = queue.poll();
    if(!visited[num]) {
      visited[num] = true;
      count++;
      ArrayList<Integer> arr = hm.get(num);
      for(int n : arr) {
        if(visited[n]) continue;
        queue.add(n);
      }
    }
  }
}
```