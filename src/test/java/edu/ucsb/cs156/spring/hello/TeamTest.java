package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void toString_returns_correct_string(){
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_not_same_obj(){
        int x = 0;
        assertEquals(false, team.equals(x));
    }

    @Test
    public void equals_same_obj(){
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_team(){
        Team team1 = new Team("test-team");
        assertEquals(true, team.equals(team1));
    }

    @Test
    public void equals_not_team_mem(){
        Team team1 = new Team("wrong-team");
        team1.addMember("NIC XAVIER");
        assertEquals(false, team.equals(team1));
    }

    @Test
    public void equals_team_not_mem_not_team() {
        Team team1 = new Team("test-team");
        team.addMember("NIC XAVIER");
        assertEquals(false, team.equals(team1));

        Team team2 = new Team("wrong-team");
        assertEquals(false, team.equals(team2));
    }

    @Test
    public void hash_code_test() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hash_code_test_specific() {
        Team t = new Team("");
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }





}
