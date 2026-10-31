package com.example.app;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class App {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(
                new InetSocketAddress(8081), 0);

        server.createContext("/", exchange -> {

            String response = """
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport"
                          content="width=device-width, initial-scale=1.0">

                    <title>Bhavani | Portfolio</title>

                    <style>

                        * {
                            margin: 0;
                            padding: 0;
                            box-sizing: border-box;
                            scroll-behavior: smooth;
                        }

                        body {
                            font-family: Arial, sans-serif;
                            background: #080f1e;
                            color: #ffffff;
                            line-height: 1.7;
                        }

                        /* NAVIGATION */

                        header {
                            background: #101e34;
                            padding: 20px 10%;
                            display: flex;
                            justify-content: space-between;
                            align-items: center;
                            position: sticky;
                            top: 0;
                            z-index: 100;
                            border-bottom: 1px solid #24354c;
                        }

                        .logo {
                            font-size: 25px;
                            font-weight: bold;
                            color: white;
                        }

                        .logo span {
                            color: #00c9f5;
                        }

                        nav a {
                            color: #d6e0ec;
                            text-decoration: none;
                            margin-left: 25px;
                            font-size: 14px;
                            transition: 0.3s;
                        }

                        nav a:hover {
                            color: #00c9f5;
                        }

                        /* HOME SECTION */

                        .home {
                            min-height: 85vh;
                            display: flex;
                            justify-content: space-between;
                            align-items: center;
                            padding: 80px 10%;
                            gap: 50px;
                            background:
                                radial-gradient(
                                    circle at 80% 40%,
                                    #123956,
                                    #080f1e 55%
                                );
                        }

                        .home-content {
                            max-width: 650px;
                        }

                        .welcome {
                            color: #00c9f5;
                            letter-spacing: 3px;
                            font-size: 13px;
                            font-weight: bold;
                            margin-bottom: 20px;
                        }

                        .home h1 {
                            font-size: 52px;
                            margin-bottom: 15px;
                        }

                        .home h1 span {
                            color: #00c9f5;
                        }

                        .home h3 {
                            font-size: 21px;
                            color: #d5e4f1;
                            margin-bottom: 20px;
                        }

                        .home p {
                            color: #aabbd0;
                            font-size: 16px;
                            margin-bottom: 30px;
                        }

                        .buttons {
                            display: flex;
                            gap: 15px;
                        }

                        .btn {
                            display: inline-block;
                            padding: 12px 25px;
                            border-radius: 5px;
                            text-decoration: none;
                            font-weight: bold;
                            font-size: 14px;
                            transition: 0.3s;
                        }

                        .btn-primary {
                            background: #00bfe9;
                            color: #071321;
                        }

                        .btn-outline {
                            border: 1px solid #00c9f5;
                            color: #00c9f5;
                        }

                        .btn:hover {
                            transform: translateY(-3px);
                            opacity: 0.9;
                        }

                        /* PROFILE CIRCLE */

                        .profile-circle {
                            width: 250px;
                            height: 250px;
                            min-width: 250px;
                            border: 2px solid #00c9f5;
                            border-radius: 50%;
                            display: flex;
                            align-items: center;
                            justify-content: center;
                            background: #122b43;
                            box-shadow: 0 0 60px #00c9f522;
                        }

                        .profile-circle h2 {
                            font-size: 65px;
                            color: white;
                        }

                        /* COMMON SECTIONS */

                        section {
                            padding: 90px 10%;
                        }

                        .section-label {
                            color: #00c9f5;
                            font-size: 13px;
                            letter-spacing: 2px;
                            font-weight: bold;
                            margin-bottom: 10px;
                        }

                        .section-title {
                            font-size: 36px;
                            margin-bottom: 30px;
                        }

                        .section-title span {
                            color: #00c9f5;
                        }

                        /* ABOUT */

                        .about {
                            background: #0c1728;
                        }

                        .about p {
                            color: #b6c6d7;
                            max-width: 900px;
                            font-size: 16px;
                            margin-bottom: 15px;
                        }

                        /* SKILLS */

                        .skills-grid {
                            display: grid;
                            grid-template-columns:
                                repeat(auto-fit, minmax(180px, 1fr));
                            gap: 20px;
                        }

                        .skill-card {
                            background: #12233a;
                            padding: 25px;
                            text-align: center;
                            border-radius: 8px;
                            border: 1px solid #243b53;
                            font-size: 17px;
                            font-weight: bold;
                            transition: 0.3s;
                        }

                        .skill-card:hover {
                            border-color: #00c9f5;
                            transform: translateY(-5px);
                        }

                        /* PROJECTS */

                        .projects {
                            background: #0c1728;
                        }

                        .projects-grid {
                            display: grid;
                            grid-template-columns:
                                repeat(auto-fit, minmax(280px, 1fr));
                            gap: 25px;
                        }

                        .project-card {
                            background: #12233a;
                            padding: 30px;
                            border-radius: 10px;
                            border: 1px solid #243b53;
                            transition: 0.3s;
                        }

                        .project-card:hover {
                            border-color: #00c9f5;
                            transform: translateY(-5px);
                        }

                        .project-card h3 {
                            color: #00c9f5;
                            margin-bottom: 15px;
                        }

                        .project-card p {
                            color: #b6c6d7;
                            font-size: 14px;
                        }

                        .tech {
                            margin-top: 20px;
                            font-size: 13px;
                            color: #72dff5;
                        }

                        /* EDUCATION */

                        .education-card {
                            background: #12233a;
                            padding: 30px;
                            border-left: 4px solid #00c9f5;
                            border-radius: 8px;
                            max-width: 800px;
                        }

                        .education-card h3 {
                            color: #00c9f5;
                            margin-bottom: 10px;
                        }

                        .education-card p {
                            color: #b6c6d7;
                        }

                        /* CONTACT */

                        .contact {
                            background: #0c1728;
                            text-align: center;
                        }

                        .contact p {
                            color: #b6c6d7;
                            margin-bottom: 25px;
                        }

                        /* FOOTER */

                        footer {
                            text-align: center;
                            padding: 25px;
                            background: #101e34;
                            color: #9aafc4;
                            font-size: 14px;
                        }

                        /* MOBILE RESPONSIVE */

                        @media (max-width: 850px) {

                            header {
                                flex-direction: column;
                                gap: 15px;
                            }

                            nav {
                                text-align: center;
                            }

                            nav a {
                                margin: 5px 8px;
                                display: inline-block;
                            }

                            .home {
                                flex-direction: column-reverse;
                                text-align: center;
                                padding-top: 60px;
                            }

                            .home h1 {
                                font-size: 36px;
                            }

                            .profile-circle {
                                width: 180px;
                                height: 180px;
                                min-width: 180px;
                            }

                            .profile-circle h2 {
                                font-size: 48px;
                            }

                            .buttons {
                                justify-content: center;
                            }

                            section {
                                padding: 60px 7%;
                            }

                        }

                    </style>

                </head>

                <body>

                    <!-- NAVIGATION -->

                    <header>

                        <div class="logo">
                            BHAVANI<span>.</span>
                        </div>

                        <nav>
                            <a href="#home">Home</a>
                            <a href="#about">About</a>
                            <a href="#skills">Skills</a>
                            <a href="#projects">Projects</a>
                            <a href="#education">Education</a>
                            <a href="#contact">Contact</a>
                        </nav>

                    </header>


                    <!-- HOME -->

                    <section class="home" id="home">

                        <div class="home-content">

                            <div class="welcome">
                                HELLO, WELCOME TO MY PORTFOLIO
                            </div>

                            <h1>
                                Hi, I'm <span>Bhavani</span>
                            </h1>

                            <h3>
                                Computer Science Engineering Student
                            </h3>

                            <p>
                                I am a passionate Computer Science Engineering
                                student interested in software development,
                                Java programming, web technologies and DevOps.

                                I enjoy learning new technologies,
                                solving problems and building useful
                                real-world applications.
                            </p>

                            <div class="buttons">

                                <a href="#projects"
                                   class="btn btn-primary">
                                    View My Projects
                                </a>

                                <a href="#contact"
                                   class="btn btn-outline">
                                    Contact Me
                                </a>

                            </div>

                        </div>

                        <div class="profile-circle">
                            <h2>BG</h2>
                        </div>

                    </section>


                    <!-- ABOUT -->

                    <section class="about" id="about">

                        <div class="section-label">
                            GET TO KNOW ME
                        </div>

                        <h2 class="section-title">
                            About <span>Me</span>
                        </h2>

                        <p>
                            Hello! I'm Bhavani, a B.Tech Computer Science
                            Engineering student with a strong interest in
                            programming, software development and
                            emerging technologies.
                        </p>

                        <p>
                            I enjoy working with Java, Python, databases,
                            web development and DevOps tools.
                            I am continuously improving my technical
                            skills through academic projects and
                            practical learning.
                        </p>

                        <p>
                            My goal is to become a skilled software
                            professional and contribute to meaningful
                            technology solutions.
                        </p>

                    </section>


                    <!-- SKILLS -->

                    <section id="skills">

                        <div class="section-label">
                            WHAT I KNOW
                        </div>

                        <h2 class="section-title">
                            My <span>Skills</span>
                        </h2>

                        <div class="skills-grid">

                            <div class="skill-card">Java</div>
                            <div class="skill-card">Python</div>
                            <div class="skill-card">C Programming</div>
                            <div class="skill-card">HTML & CSS</div>
                            <div class="skill-card">MySQL</div>
                            <div class="skill-card">Spring Boot</div>
                            <div class="skill-card">Git & GitHub</div>
                            <div class="skill-card">Maven</div>
                            <div class="skill-card">Docker</div>
                            <div class="skill-card">Jenkins</div>
                            <div class="skill-card">Kubernetes</div>
                            <div class="skill-card">Data Structures</div>

                        </div>

                    </section>


                    <!-- PROJECTS -->

                    <section class="projects" id="projects">

                        <div class="section-label">
                            MY WORK
                        </div>

                        <h2 class="section-title">
                            Featured <span>Projects</span>
                        </h2>

                        <div class="projects-grid">

                            <div class="project-card">

                                <h3>Smart LabCare</h3>

                                <p>
                                    A smart laboratory complaint management
                                    system that allows students to report
                                    computer issues and enables lab assistants
                                    and technicians to track and resolve
                                    complaints efficiently.
                                </p>

                                <div class="tech">
                                    Java | Spring Boot | MySQL
                                </div>

                            </div>


                            <div class="project-card">

                                <h3>SafeTrack</h3>

                                <p>
                                    A GPS-based complaint tracking system
                                    designed to report issues, track their
                                    status and manage the resolution process
                                    through different user roles.
                                </p>

                                <div class="tech">
                                    Java | Spring Boot | MySQL
                                </div>

                            </div>


                            <div class="project-card">

                                <h3>DevOps CI/CD Pipeline</h3>

                                <p>
                                    A Java web application demonstrating
                                    automated build and deployment concepts
                                    using Maven, GitHub, Jenkins, Docker
                                    and Kubernetes.
                                </p>

                                <div class="tech">
                                    Maven | Docker | Jenkins | Kubernetes
                                </div>

                            </div>

                        </div>

                    </section>


                    <!-- EDUCATION -->

                    <section id="education">

                        <div class="section-label">
                            ACADEMIC BACKGROUND
                        </div>

                        <h2 class="section-title">
                            My <span>Education</span>
                        </h2>

                        <div class="education-card">

                            <h3>
                                Bachelor of Technology - CSE
                            </h3>

                            <p>
                                Gayatri Vidya Parishad College of
                                Engineering for Women
                            </p>

                            <p>
                                Visakhapatnam, Andhra Pradesh
                            </p>

                            <p>
                                Computer Science and Engineering
                            </p>

                        </div>

                    </section>


                    <!-- CONTACT -->

                    <section class="contact" id="contact">

                        <div class="section-label">
                            GET IN TOUCH
                        </div>

                        <h2 class="section-title">
                            Contact <span>Me</span>
                        </h2>

                        <p>
                            Interested in collaborating or discussing
                            technology and projects?
                        </p>

                        <p>
                            Feel free to connect with me!
                        </p>

                    </section>


                    <!-- FOOTER -->

                    <footer>

                        <p>
                            &copy; 2026 Bhavani.
                            All Rights Reserved.
                        </p>

                        <p>
                            Built with Java, HTML, CSS and DevOps Technologies.
                        </p>

                    </footer>

                </body>
                </html>
                """;

            byte[] responseBytes =
                    response.getBytes(StandardCharsets.UTF_8);

            exchange.getResponseHeaders()
                    .set("Content-Type", "text/html; charset=UTF-8");

            exchange.sendResponseHeaders(
                    200, responseBytes.length);

            try (OutputStream output = exchange.getResponseBody()) {
                output.write(responseBytes);
            }

        });

        server.start();

        System.out.println(
                "Portfolio Website started on port 8081");
    }
}