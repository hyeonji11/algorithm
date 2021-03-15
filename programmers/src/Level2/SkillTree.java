package Level2;

public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i=0; i< skill_trees.length; i++) {
            skill_trees[i] = skill_trees[i].replaceAll("[^"+skill+"]", "");
            /*
            if(skill.length() == skill_trees[i].length() && skill.equals(skill_trees[i])) {
                answer++;
                continue;
            }
            */
            String str = skill.substring(0, skill_trees[i].length());
            if(str.equals(skill_trees[i])) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        SkillTree st = new SkillTree();
        System.out.println(st.solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
