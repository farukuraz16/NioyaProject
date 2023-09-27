@nioyaAPI
Feature: User can work on Nioya API

  Background: User goes to URL
    Given User sets the URL "https://app.asana.com/api/1.0"

  @t01 @Create
  Scenario: User can create task
    When create task with workspace gid "1205543498728328" and task name "Ironman" postPath "tasks" addPath "addProject"
    Then assert the new task "201"

  @t02 @Create
  Scenario: User can create task
    When create task with workspace gid "1205543498728328" and task name "Spiderman" postPath "tasks" addPath "addProject"
    Then assert the new task "201"

  @t03 @Create
  Scenario: User can create task
    When create task with workspace gid "1205543498728328" and task name "Hulk" postPath "tasks" addPath "addProject"
    Then assert the new task "201"

  @t04 @Create
  Scenario: User can create task
    When create task with workspace gid "1205543498728328" and task name "Captain Marvel" postPath "tasks" addPath "addProject"
    Then assert the new task "201"

  @t05 @Create
  Scenario: User can create task
    When create task with workspace gid "1205543498728328" and task name "Thor" postPath "tasks" addPath "addProject"
    Then assert the new task "201"

  @t06 @Create
  Scenario: User can create task
    When create task with workspace gid "1205543498728328" and task name "Natasha" postPath "tasks" addPath "addProject"
    Then assert the new task "201"

  @t07 @Create
  Scenario: User can create task
    When create task with workspace gid "1205543498728328" and task name "Superman" postPath "tasks" addPath "addProject"
    Then assert the new task "201"

  @t08 @Create
  Scenario: User can create task
    When create task with workspace gid "1205543498728328" and task name "Batman" postPath "tasks" addPath "addProject"
    Then assert the new task "201"

  @t09 @Create
  Scenario: User can create task
    When create task with workspace gid "1205543498728328" and task name "Wonder Woman" postPath "tasks" addPath "addProject"
    Then assert the new task "201"

  @cP1 @Create
  Scenario: User can create project
    When create project with workspace gid "1205543498728328" project name "Marvel" postPath "projects"
    Then assert the new project "201"



  @cP2 @Create
  Scenario: User can create project
    When create project with workspace gid "1205543498728328" project name "Avengers" postPath "projects"
    Then assert the new project "201"


  @cP3 @Create
  Scenario: User can create project
    When create project with workspace gid "1205543498728328" project name "DC" postPath "projects"
    Then assert the new project "201"

  @Add
  Scenario: User can add project
    When add task to project "Marvel" and task "Ironman" postPath "tasks" addPath "addProject"
    When add task to project "Marvel" and task "Spiderman" postPath "tasks" addPath "addProject"
    When add task to project "Marvel" and task "Hulk" postPath "tasks" addPath "addProject"
    When add task to project "Avengers" and task "Captain Marvel" postPath "tasks" addPath "addProject"
    When add task to project "Avengers" and task "Thor" postPath "tasks" addPath "addProject"
    When add task to project "Avengers" and task "Natasha" postPath "tasks" addPath "addProject"
    When add task to project "DC" and task "Superman" postPath "tasks" addPath "addProject"
    When add task to project "DC" and task "Batman" postPath "tasks" addPath "addProject"
    When add task to project "DC" and task "Wonder Woman" postPath "tasks" addPath "addProject"

  @dT
  Scenario: User can delete task
    When delete task "Ironman" postPath "tasks"
    Then assert the task deleted "200"
    When delete task "Spiderman" postPath "tasks"
    Then assert the task deleted "200"
    When delete task "Hulk" postPath "tasks"
    Then assert the task deleted "200"
    When delete task "Captain Marvel" postPath "tasks"
    Then assert the task deleted "200"
    When delete task "Thor" postPath "tasks"
    Then assert the task deleted "200"
    When delete task "Natasha" postPath "tasks"
    Then assert the task deleted "200"
    When delete task "Superman" postPath "tasks"
    Then assert the task deleted "200"
    When delete task "Batman" postPath "tasks"
    Then assert the task deleted "200"
    When delete task "Wonder Woman" postPath "tasks"
    Then assert the task deleted "200"





   #When delete task 2 postPath "tasks"
   #Then assert the task deleted "200"
   #When delete task 3 postPath "tasks"
   #Then assert the task deleted "200"
   #When delete task 4 postPath "tasks"
   #Then assert the task deleted "200"
   #When delete task 5 postPath "tasks"
   #Then assert the task deleted "200"
   #When delete task 6 postPath "tasks"
   #Then assert the task deleted "200"
   #When delete task 7 postPath "tasks"
   #Then assert the task deleted "200"
   #When delete task 8 postPath "tasks"
   #Then assert the task deleted "200"
   #When delete task 9 postPath "tasks"
   #Then assert the task deleted "200"

  @dP
  Scenario: User can delete project
    When delete project "Marvel" postPath "projects"
    Then assert the project deleted "200"
    When delete project "Avengers" postPath "projects"
    Then assert the project deleted "200"
    When delete project "DC" postPath "projects"
    Then assert the project deleted "200"


