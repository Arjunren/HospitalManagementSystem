# Hospital Management System

## Overview

A secure Spring Boot API for patients, doctors, appointments, clinical completion notes, and operational dashboards.

## Features

- Revocable authentication and admin/doctor/receptionist/patient roles
- Admin doctor records and staff-created patient records
- Patient/staff booking, doctor search, pagination, scoped appointment views
- Transactional double-booking prevention with PostgreSQL range exclusion
- Doctor-owned diagnosis/treatment completion, cancellation, audit timestamps, health, Docker and CI

## Technology Stack

Java 25, Spring Boot 4.1.1, Web MVC, Security, Data JPA, Validation, Flyway, PostgreSQL 17, H2 tests, Maven Wrapper.

## Requirements

Java 25 and PostgreSQL 15+ with `btree_gist` permission, or Docker.

## Installation

Run `Copy-Item .env.example .env` and `.\mvnw.cmd clean package`.

## Environment Variables

Configure `DATABASE_URL`, `DATABASE_USERNAME`, `DATABASE_PASSWORD`; optional `TOKEN_TTL_MINUTES`, `ALLOWED_ORIGINS`, `SPRING_PROFILES_ACTIVE`.

## Database Setup

Flyway applies the schema at startup. `docker compose up --build` provisions PostgreSQL and the API.

## Running the Application

Set `$env:SPRING_PROFILES_ACTIVE='dev'` and run `.\mvnw.cmd spring-boot:run`. Health: `/actuator/health`.

## Running Tests

Run `.\mvnw.cmd verify`.

## Default Development Accounts

With `dev`: admin `admin@example.com` / `AdminPassword123!`; receptionist `reception@example.com` / `ReceptionPassword123!`; doctor `doctor@example.com` / `DoctorPassword123!`; patient `patient@example.com` / `PatientPassword123!`. Development only.

## API Endpoints

`POST /api/auth/login|logout`; `GET/POST /api/doctors`; `POST /api/patients`; `GET/POST /api/appointments`; `GET /api/appointments/{id}`; `PATCH /api/appointments/{id}/cancel|complete`; `GET /api/dashboard`.

## Folder Structure

Explicit controller, service, repository, entity, DTO, security, configuration, exception, and Flyway migration layers.

## Security Notes

BCrypt cost 12, hashed revocable bearer tokens, login throttling/timing equalization, RBAC, patient/doctor scope checks, DTO validation, parameterized JPA, doctor row locks plus exclusion constraints, bounded pages, allow-listed CORS, and safe errors.

## Known Limitations

Admissions, beds, prescriptions, labs, billing, files, insurance, reminders, MFA, password recovery, and regulatory medical-record compliance are outside this portfolio scope. Clinical notes are intentionally simple.
