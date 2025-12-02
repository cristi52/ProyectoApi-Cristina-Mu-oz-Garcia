-- Poblar tabla status
INSERT INTO status (status_name) VALUES ('En progreso');
INSERT INTO status (status_name) VALUES ('Finalizado');

-- Poblar tabla technologies
INSERT INTO technologies (tech_name) VALUES ('Java');
INSERT INTO technologies (tech_name) VALUES ('Spring Boot');
INSERT INTO technologies (tech_name) VALUES ('MySQL');

-- Poblar tabla developers
INSERT INTO developers (devname, dev_surname, email, linkedin_url, github_url)
VALUES ('Cristina', 'García', 'cristina@example.com', 'https://linkedin.com/in/cristina', 'https://github.com/cristina');

INSERT INTO developers (devname, dev_surname, email, linkedin_url, github_url)
VALUES ('Juan', 'Pérez', 'juan@example.com', 'https://linkedin.com/in/juan', 'https://github.com/juan');

-- Poblar tabla projects
INSERT INTO projects (project_name, description, start_date, end_date, demo_url, picture, status_status_id)
VALUES ('Proyecto Demo', 'Primer proyecto de prueba', '2025-12-01', '2025-12-31', 'https://demo.com', 'imagen.png', 1);

-- Relacionar proyecto con tecnologías
INSERT INTO technologies_used_in_projects (tecnologia_tecnologia_id, projects_project_id)
VALUES (1, 1), (2, 1);

-- Relacionar proyecto con desarrolladores
INSERT INTO developers_worked_on_projects (developer_dev_id, projects_project_id)
VALUES (1, 1), (2, 1);
