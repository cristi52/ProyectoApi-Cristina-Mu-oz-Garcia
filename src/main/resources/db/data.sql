-- -------------------------------
-- Insertar tecnologías
INSERT IGNORE INTO technologies (tech_name) VALUES
('Python'),
('Java'),
('JavaScript'),
('HTML/CSS'),
('MySQL');

-- -------------------------------
-- Insertar desarrolladores
INSERT IGNORE INTO developers (devname, dev_surname, email, linkedin_url, github_url) VALUES
('cristi', 'Muño', 'cristi@example.com', 'https://linkedin.com/in/cristi', 'https://github.com/cristi'),
('ana', 'García', 'ana@example.com', 'https://linkedin.com/in/ana', 'https://github.com/ana'),
('pablo', 'López', 'pablo@example.com', 'https://linkedin.com/in/pablo', 'https://github.com/pablo');

-- -------------------------------
-- Insertar proyectos
INSERT INTO projects (project_name, description, start_date, end_date, demo_url, picture, status_status_id) VALUES
('API REST Proyectos', 'Proyecto de API REST con MySQL', '2025-12-01', '2025-12-15', 'https://demo.com/api', 'api.png', 31),
('Web Portfolio', 'Portfolio personal de desarrollador', '2025-11-15', '2025-12-05', 'https://demo.com/portfolio', 'portfolio.png', 32);

-- -------------------------------
-- Relación proyectos-tecnologías
INSERT INTO technologies_used_in_projects (tecnologia_tecnologia_id, projects_project_id) VALUES
((SELECT tech_id FROM technologies WHERE tech_name='Python'),
 (SELECT project_id FROM projects WHERE project_name='API REST Proyectos')),
((SELECT tech_id FROM technologies WHERE tech_name='MySQL'),
 (SELECT project_id FROM projects WHERE project_name='API REST Proyectos')),
((SELECT tech_id FROM technologies WHERE tech_name='JavaScript'),
 (SELECT project_id FROM projects WHERE project_name='Web Portfolio')),
((SELECT tech_id FROM technologies WHERE tech_name='HTML/CSS'),
 (SELECT project_id FROM projects WHERE project_name='Web Portfolio'));

-- Relación proyectos-desarrolladores
INSERT INTO developers_worked_on_projects (developer_dev_id, projects_project_id) VALUES
((SELECT dev_id FROM developers WHERE devname='cristi' AND dev_surname='Muño'),
 (SELECT project_id FROM projects WHERE project_name='API REST Proyectos')),
((SELECT dev_id FROM developers WHERE devname='ana' AND dev_surname='García'),
 (SELECT project_id FROM projects WHERE project_name='API REST Proyectos')),
((SELECT dev_id FROM developers WHERE devname='pablo' AND dev_surname='López'),
 (SELECT project_id FROM projects WHERE project_name='Web Portfolio'));

