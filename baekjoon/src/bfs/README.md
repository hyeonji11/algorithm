## 1. 바이러스(Virus.java)

이 문제는 dfs를 이용해서 풀 수도 있지만 제일 가까이 연결된 컴퓨터부터 바이러스가 걸리기 때문에 bfs로 구현했다.

구현 순서
1) 연결된 컴퓨터 쌍을 저장
2) 컴퓨터1을 큐에 넣고 거기에 연결된 컴퓨터들을 계속 큐에 넣으면서 방문했는지 체크
3) 처음 방문한 컴퓨터는 count변수로 세기

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

## 3. 트리의 부모 찾기(FindTreeParent.java)

이 문제에서는 값들을 입력받을 때 처음으로 StringTokenizer를 사용해봤다.
지금까지는 항상 BufferedReader로 받은 다음 split 메소드로 문자열을 잘라서 사용했는데 split은 정규식을 기반으로 자르기 때문에 내부가 복잡하고 StringTokenizer의 nextToken 메소드는 공백 자리를 땡겨서 채우는 방식이기 때문에 정규식 처리가 필요 없다면 StringTokenizer를 사용하는게 더 빠르다고 한다.

실제로 StringTokenizer를 썼을때와 안썼을 때의 풀이 결과를 비교하면 시간이 줄어들었다. 또한, BufferedReader와 split()메소드를 사용했을 때는 String 배열에 잘라진 문자열을 저장해야 돼서 메모리를 추가로 사용했는데 StringTokenizer를 사용했을 때는 String 배열을 사용하지 않아서 메모리도 절약할 수 있었다.

연결된 정점을 표시하는 것은 ArrayList<Integer> 타입의 배열을 만들어서 배열의 인덱스를 정점으로 생각하고 그 정점과 연결된 정점들을 ArrayList에 넣어서 배열에 저장하는 형식으로 구현했다.
```
StringTokenizer st;
ArrayList<Integer> list[] = new ArrayList[vertex+1];
int v1, v2;
for(int i=0; i<vertex-1; i++) {
  st = new StringTokenizer(br.readLine());
  //String str[] = br.readLine().split(" ");  //StringTokenizer를 사용하지 않을 때 한줄씩 입력받을 때마다 Stirng 배열을 새로 생성하기 때문에 메모리를 차지함
  v1 = Integer.parseInt(st.nextToken());
  v2 = Integer.parseInt(st.nextToken());
  list[v1].add(v2);
  list[v2].add(v1);
}
```

부모 노드의 번호는 parent 배열에 저장했다.
부모를 확인하는 과정은 1)큐에서 뺀 노드번호를 list의 인덱스로 써서 그 노드와 연결된 노드들을 확인하고 2)만약 연결된 노드들의 부모 노드가 저장되지 않았다면 3)저장한 후 그 노드들을 큐에 넣는 식으로 구현했다.
```
q.offer(1);
while(!q.isEmpty()) {
  int key = q.poll();
  for(int num: list[key]) {   // 1)
    if(parent[num] != 0) continue;    // 2)
    parent[num] = key;    // 3)
    q.offer(num);
  }
}
```

## 4. 미로 탐색(MazeSearch.java)

이 문제는 예전에 비슷한 문제를 푼 적이 있어서 비슷한 방식으로 풀어냈다.

구현 순서
1) 입력받기
2) 지나는 칸 수 세기

1번은 입력을 2차원 int 배열에 저장하는 것으로 구현했다.
평소 사용하던 코드는 BufferedReader를 사용해 한줄씩 받은 후 split() 메소드로 한글자씩 배열에 저장해서 Integer로 변환하는 방식이다.
```
String[] arr;
for(int i=0; i < row; i++) {
  arr = br.readLine().split("");
  for(int j=0; j<col; j++) {
    maze[i][j] = Integer.parseInt(arr[j]);
  }
}
```
하지만 정규식이 시간복잡도가 높다는 것을 알게 되고 아래 코드로 바꿔서 채점해보니 시간과 메모리 둘 다 절약할 수 있게 되었다. 메모리는 String 배열을 매번 생성하지 않아서 줄어든 것 같다.
```
for(int i=0; i < row; i++) {
  String str = br.readLine();
  for(int j=0; j<col; j++) {
    maze[i][j] = str.charAt(j) - '0';
  }
}
```

2번은 좌표가 들어간 큐를 돌면서 다음 좌표의 값이 1이면 큐에 좌표를 넣고 다음 좌표의 값에 현재 좌표값+1을 넣도록 구현했다.
반복문을 돌고 난 뒤에는 (N, M)의 좌표를 출력하면 지나온 칸의 수를 알 수 있다. 