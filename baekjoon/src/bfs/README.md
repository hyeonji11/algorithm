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

## 2. 유기농 배추(OrganicCabbage.java)

이 문제는 크게 두 순서로 나눠서 구현했다.
1) 배열에 배추 위치 표시
2) 배추의 수만큼 돌면서 인접한 구역 세기

1번은 2차원 배열에 배추가 있는 곳만 1을 넣고 나머지는 0으로 표시했다. 배추가 있는 좌표는 따로 loc라는 2차원 배열에 저장했다.

2번은 좌표 배열이 들어가는 Queue를 만들고 배추의 좌표를 하나씩 queue에 넣어서 그 배추와 인접한 배추를 다 방문해 인접한 배추를 모두 방문하면 count변수를 1씩 올려서 구역의 개수를 세었다.
인접한 배추는 상, 하, 좌, 우로 움직였을때 배추가 심어져 있어야 되기 때문에 네 방향을 dx, dy배열에 움직이는 좌표를 넣어서 방문할 수 있도록 구현했다.
```
static int[] dx = {1, 0, -1, 0};
static int[] dy = {0, 1, 0, -1};
```

배추를 방문하면 그 위치에 1대신 0을 넣고 배추의 수만큼 돌때 1이 아니라면 queue에 배추 좌표를 넣지 않도록 처리했다.
```
if(area[arr[1]][arr[0]] == 1) {
  area[arr[1]][arr[0]] = 0;
  int nx = 0;
  int ny = 0;
  for(int d=0; d<4; d++) {
    nx = arr[0]+dx[d];
    ny = arr[1]+dy[d];
    if(nx<0 || ny<0 || nx>=area[arr[1]].length ||ny>=area.length) continue;
    if(area[ny][nx] == 1) {
      list.offer(new int[] {nx, ny});
    }
  }
}
```